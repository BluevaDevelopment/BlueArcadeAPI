package net.blueva.arcade.api.game;

import net.blueva.arcade.api.events.CustomEventRegistry;
import net.blueva.arcade.api.setup.ModuleSetupMetadata;
import net.blueva.arcade.api.setup.SetupRequirement;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main interface implemented by all game modules.
 * Module metadata is loaded from module.yml automatically.
 */
public interface GameModule<P, L, W, M, I, S, B, E, Ls, Pr> {

    // === LIFECYCLE ===

    /**
     * Called when module is loaded (once, on server start).
     * Use this to:
     * - Register game in vote menu
     * - Initialize static resources
     *
     * Configuration is OPTIONAL - access via getModuleConfig() if needed.
     */
    void onLoad();

    /**
     * Called when a game starts in an arena.
     * Use this to initialize game-specific logic.
     *
     * @param context Game context with all APIs
     */
    void onStart(GameContext<P, L, W, M, I, S, B, E> context);

    /**
     * Called when a game ends.
     *
     * @param context Game context
     * @param result Game result with winner and players
     */
    void onEnd(GameContext<P, L, W, M, I, S, B, E> context, GameResult<P> result);

    /**
     * Called when module is unloaded (server shutdown/reload).
     */
    void onDisable();

    // === EVENTS ===
    void registerEvents(CustomEventRegistry<Ls, Pr> registry);

    // === OPTIONAL HOOKS ===

    /**
     * Called after countdown finishes and game starts.
     */
    default void onGameStart(GameContext<P, L, W, M, I, S, B, E> context) {
        // Optional - modules can override
    }

    default void onGameTick(GameContext<P, L, W, M, I, S, B, E> context, int secondsRemaining) {}
    default void onPlayerEliminate(GameContext<P, L, W, M, I, S, B, E> context, P player, String reason) {}
    default void onPlayerRespawn(GameContext<P, L, W, M, I, S, B, E> context, P player) {}

    default Map<String, String> getCustomPlaceholders(P player) {
        return Map.of();
    }

    /**
     * Called every tick during countdown phase.
     * Use this to send countdown titles/sounds.
     *
     * @param context Game context
     * @param secondsLeft Seconds remaining in countdown
     */
    default void onCountdownTick(GameContext<P, L, W, M, I, S, B, E> context, int secondsLeft) {
        // Modules can override to customize countdown
    }

    /**
     * Called when countdown finishes, just before game starts.
     * Use this to send "GO!" title or final preparation.
     *
     * @param context Game context
     */
    default void onCountdownFinish(GameContext<P, L, W, M, I, S, B, E> context) {
        // Modules can override
    }

    /**
     * Should players be frozen during countdown?
     * If true, players cannot move during countdown phase.
     *
     * @return true to freeze players, false to allow movement
     */
    default boolean freezePlayersOnCountdown() {
        return true; // Default: freeze players
    }

    // === CAPABILITIES (since 3.2) ===

    /**
     * Returns the set of default setup requirements that this module explicitly
     * disables. Requirements not present in the returned set remain enforced as
     * usual (backward-compatible default).
     * <p>
     * When a requirement is disabled:
     * <ul>
     *   <li>Setup flows will skip prompts for that requirement.</li>
     *   <li>Minigame enable/boot validation will skip checks for that requirement.</li>
     * </ul>
     * Override this method to opt out of one or more default requirements.
     * </p>
     *
     * @return an unmodifiable set of disabled requirements, empty by default
     * @since 3.2
     */
    default Set<SetupRequirement> getDisabledRequirements() {
        return Collections.emptySet();
    }

    /**
     * Declares whether players may join an in-progress match in
     * <b>standalone</b> mode.
     * <p>
     * Defaults to {@code false} (joining after start is not allowed).
     * Even if this returns {@code true}, the core will <b>never</b>
     * allow join-in-progress in <b>party</b> mode.
     * </p>
     *
     * @return {@code true} to allow join-in-progress in standalone mode
     * @since 3.2
     */
    default boolean allowJoinInProgress() {
        return false;
    }

    /**
     * Called when a player joins an already-running match, right after the core has
     * registered them in this game's {@link GameContext}.
     * <p>
     * Only invoked when {@link #allowJoinInProgress()} returned {@code true} for the
     * arena. The module is responsible for actually placing the player into the match
     * (team assignment, teleporting them into the game world, equipping their loadout,
     * etc.) — the core does not do this on its behalf, since it is entirely
     * game-specific.
     * </p>
     * <p>
     * Return {@code false} to reject the join-in-progress attempt (e.g. every team is
     * already full). When rejected, the core undoes the registration and notifies the
     * player instead of leaving them stuck in a half-joined state. The default
     * implementation always rejects, since a module that never overrides this method
     * has no way to actually place the player into the match.
     * </p>
     *
     * @param context Game context with all APIs
     * @param player the player joining the running match
     * @return {@code true} if the player was placed into the match successfully
     * @since 3.4
     */
    default boolean onPlayerJoinInProgress(GameContext<P, L, W, M, I, S, B, E> context, P player) {
        return false;
    }

    /**
     * Returns a human-readable display name for this module.
     * The default implementation returns {@code null}, which signals the core to
     * fall back to the module descriptor name or language.yml lookup.
     * Override this to expose the display name from your own config (e.g. language.yml).
     *
     * @return display name, or {@code null} to use the descriptor fallback
     * @since 3.3
     */
    default String getDisplayName() {
        return null;
    }

    /**
     * Returns optional declarative install/setup metadata for this module.
     * <p>
     * Metadata is used by the core to enrich admin help, setup status checklists,
     * and diagnostics. It does not replace setup command handlers or validation.
     * Existing modules can ignore this method and will keep working unchanged.
     * </p>
     *
     * @return setup metadata, empty by default
     * @since 3.4
     */
    default ModuleSetupMetadata getSetupMetadata() {
        return ModuleSetupMetadata.empty();
    }

    /**
     * Returns whether the core should require enough configured spawn points
     * for this module before the game can be enabled.
     * <p>
     * Returning {@code false} keeps core spawn setup commands available, but
     * disables only the numeric one-spawn-per-player capacity check. Use
     * {@link #getDisabledRequirements()} with {@link SetupRequirement#SPAWNS}
     * when the module does not use the core spawn requirement at all.
     * </p>
     *
     * @return {@code true} by default for backward-compatible validation
     * @since 3.4
     */
    default boolean requiresSpawnCapacityValidation() {
        return true;
    }
}
