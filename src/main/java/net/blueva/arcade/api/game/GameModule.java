package net.blueva.arcade.api.game;

import net.blueva.arcade.api.events.CustomEventRegistry;

import java.util.List;
import java.util.Map;

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
}
