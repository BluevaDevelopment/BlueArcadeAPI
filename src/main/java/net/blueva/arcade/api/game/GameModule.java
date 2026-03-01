package net.blueva.arcade.api.game;

import net.blueva.arcade.api.events.CustomEventRegistry;
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
}
