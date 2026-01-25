package net.blueva.arcade.api.game;

/**
 * Represents the different phases of a game lifecycle.
 * <p>
 * A game typically progresses through these phases in order:
 * WAITING → COUNTDOWN → PLAYING → ENDING → FINISHED
 * </p>
 */
public enum GamePhase {
    /**
     * The game is waiting for players to join before it can start.
     * This is the initial phase when a game arena is created.
     */
    WAITING,

    /**
     * The game has enough players and is counting down before starting.
     * Players can no longer join during this phase in most game modes.
     */
    COUNTDOWN,

    /**
     * The game is actively being played.
     * This is the main gameplay phase where players compete.
     */
    PLAYING,

    /**
     * The game is ending and showing results.
     * This phase typically includes the podium display and statistics summary.
     */
    ENDING,

    /**
     * The game has completely finished and the arena is ready to be cleaned up.
     * No more game logic will be executed after this phase.
     */
    FINISHED
}
