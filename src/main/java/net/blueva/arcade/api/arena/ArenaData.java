package net.blueva.arcade.api.arena;

/**
 * Represents a read-only snapshot of arena configuration data.
 * <p>
 * This interface provides access to the core properties of an arena, including its
 * identification, game association, player limits, and configuration settings.
 * The data is immutable and represents a point-in-time snapshot of the arena's state.
 * </p>
 */
public interface ArenaData {

    /**
     * Gets the unique identifier of this arena.
     *
     * @return the arena ID
     */
    int getId();

    /**
     * Gets the identifier of the game module this arena is configured for.
     *
     * @return the game module ID
     */
    String getGameId();

    /**
     * Gets the name of the world where this arena is located.
     *
     * @return the world name
     */
    String getWorldName();

    /**
     * Checks if this arena is currently enabled and available for use.
     *
     * @return true if the arena is enabled, false otherwise
     */
    boolean isEnabled();

    /**
     * Gets the minimum number of players required to start a game in this arena.
     *
     * @return the minimum player count
     */
    int getMinPlayers();

    /**
     * Gets the maximum number of players allowed in this arena.
     *
     * @return the maximum player count
     */
    int getMaxPlayers();

    /**
     * Gets the configured time limit for games in this arena.
     * <p>
     * The meaning and units of this value are game-specific.
     * Common interpretations include game duration in seconds or countdown time.
     * </p>
     *
     * @return the time configuration value
     */
    int getTime();
}
