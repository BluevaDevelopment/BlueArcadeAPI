package net.blueva.arcade.api.utils;

/**
 * Utility methods for player-related operations.
 */
public interface PlayerUtil<P> {

    /**
     * Get the arena ID where a player is currently playing.
     * @param player The player
     * @return Arena ID, or null if player is not in an arena
     */
    Integer getPlayerArena(P player);

    /**
     * Check if player is currently in a game.
     * @param player The player
     * @return true if player is in a game
     */
    boolean isInGame(P player);

    /**
     * Get player's current game status.
     * @param player The player
     * @return Status string (e.g., "Playing", "Spectator"), or null
     */
    String getPlayerStatus(P player);

    /**
     * Get player's in-game status.
     * @param player The player
     * @return In-game status (e.g., "Playing", "SPECTATOR"), or null
     */
    String getPlayerInGameStatus(P player);

    /**
     * Check if player is currently in a waiting arena.
     * @param player The player
     * @return true if player is in a waiting arena
     */
    boolean isInWaitingArena(P player);
}
