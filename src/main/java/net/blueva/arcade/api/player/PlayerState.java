package net.blueva.arcade.api.player;

/**
 * Represents the different states a player can be in during a game.
 * <p>
 * Players typically start as PLAYING and may transition to ELIMINATED or SPECTATOR
 * based on game events and rules.
 * </p>
 */
public enum PlayerState {
    /**
     * The player is actively participating in the game.
     * This is the default state for players who are alive and competing.
     */
    PLAYING,

    /**
     * The player is spectating the game.
     * Spectators can watch the game but cannot interact with gameplay elements.
     * This state is typically used for players who join after the game has started.
     */
    SPECTATOR,

    /**
     * The player has been eliminated from the game.
     * Eliminated players can no longer participate but may still be in the arena
     * as spectators depending on the game configuration.
     */
    ELIMINATED
}
