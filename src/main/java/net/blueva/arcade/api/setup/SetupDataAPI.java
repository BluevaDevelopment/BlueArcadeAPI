package net.blueva.arcade.api.setup;

import java.util.List;

/**
 * API for modules to save and load game configuration data.
 * <p>
 * This interface provides methods to persist game-specific settings to JSON configuration
 * files. It is accessible from {@link SetupContext} during arena setup commands.
 * </p>
 *
 * @param <L> the location type (platform-specific)
 */
public interface SetupDataAPI<L> {

    /**
     * Saves a string value to game configuration.
     *
     * @param path the dot-notation path (e.g., "basic.music_time")
     * @param value the string value to save
     */
    void setString(String path, String value);

    /**
     * Saves an integer value to game configuration.
     *
     * @param path the dot-notation path
     * @param value the integer value to save
     */
    void setInt(String path, int value);

    /**
     * Saves a double value to game configuration.
     *
     * @param path the dot-notation path
     * @param value the double value to save
     */
    void setDouble(String path, double value);

    /**
     * Saves a boolean value to game configuration.
     *
     * @param path the dot-notation path
     * @param value the boolean value to save
     */
    void setBoolean(String path, boolean value);

    /**
     * Save the team configuration for a game.
     *
     * @param teamCount number of teams
     * @param teamSize max players per team
     */
    void setTeamConfig(int teamCount, int teamSize);

    /**
     * Saves a list of strings to game configuration.
     *
     * @param path the dot-notation path
     * @param values the list of strings to save
     */
    void setStringList(String path, List<String> values);

    /**
     * Saves a location to game configuration.
     *
     * @param path the dot-notation path
     * @param location the location to save
     */
    void setLocation(String path, L location);

    /**
     * Save a region snapshot (bounds + blocks) to game config and register it for regeneration.
     *
     * @param path Base path where the region will be stored (e.g., "game.floor")
     * @param pos1 First corner of the region
     * @param pos2 Second corner of the region
     */
    void registerRegenerationRegion(String path, L pos1, L pos2);

    /**
     * Save the blocks within a region to a specific path.
     *
     * @param path Path where the block list will be stored (e.g., "game.floor.blocks")
     * @param pos1 First corner of the region
     * @param pos2 Second corner of the region
     */
    void saveRegionBlocks(String path, L pos1, L pos2);

    /**
     * Save region bounds (min/max) to game config.
     *
     * @param path Base path (e.g., "game.finish_line.bounds")
     * @param pos1 First position
     * @param pos2 Second position
     */
    void setRegionBounds(String path, L pos1, L pos2);

    /**
     * Gets a string value from game configuration.
     *
     * @param path the dot-notation path
     * @return the string value, or null if not found
     */
    String getString(String path);

    /**
     * Gets an integer value from game configuration.
     *
     * @param path the dot-notation path
     * @param defaultValue the default value if not found
     * @return the integer value, or defaultValue if not found
     */
    int getInt(String path, int defaultValue);

    /**
     * Gets an integer from arena configuration.
     *
     * @param path the dot-notation path
     * @param defaultValue the default value if not found
     * @return the integer value, or defaultValue if not found
     */
    int getArenaInt(String path, int defaultValue);

    /**
     * Gets a double value from game configuration.
     *
     * @param path the dot-notation path
     * @param defaultValue the default value if not found
     * @return the double value, or defaultValue if not found
     */
    double getDouble(String path, double defaultValue);

    /**
     * Gets a boolean value from game configuration.
     *
     * @param path the dot-notation path
     * @param defaultValue the default value if not found
     * @return the boolean value, or defaultValue if not found
     */
    boolean getBoolean(String path, boolean defaultValue);

    /**
     * Gets a location from game configuration.
     *
     * @param path the dot-notation path
     * @return the location, or null if not found
     */
    L getLocation(String path);

    /**
     * Checks if a path exists in game configuration.
     *
     * @param path the dot-notation path to check
     * @return true if the path exists, false otherwise
     */
    boolean has(String path);

    /**
     * Removes a value from game configuration.
     *
     * @param path the dot-notation path to remove
     */
    void remove(String path);

    /**
     * Saves all configuration changes to disk.
     */
    void save();
}
