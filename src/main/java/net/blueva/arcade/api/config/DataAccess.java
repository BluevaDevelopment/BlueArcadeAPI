package net.blueva.arcade.api.config;

/**
 * Provides read-only access to arena and game configuration data from JSON files.
 * <p>
 * DataAccess reads from the arena's JSON configuration files stored at:
 * <ul>
 *   <li>Arena data: {@code /data/arenas/{arenaId}/arena.json}</li>
 *   <li>Game data: {@code /data/arenas/{arenaId}/games/{gameId}.json}</li>
 * </ul>
 * This interface uses dot-notation paths to navigate nested JSON structures.
 * </p>
 *
 * @param <L> the location type (platform-specific)
 */
public interface DataAccess<L> {

    /**
     * Gets typed data from the game's configuration JSON file.
     * <p>
     * Example path: {@code "basic.initial_music_time"} to access nested values.
     * </p>
     *
     * @param <T> the expected return type
     * @param path the dot-notation path to the value
     * @param type the class of the expected type
     * @return the value at the specified path, or null if not found
     */
    <T> T getGameData(String path, Class<T> type);

    /**
     * Gets typed data from the arena configuration JSON file.
     * <p>
     * Example path: {@code "bounds.min"} to access nested values.
     * </p>
     *
     * @param <T> the expected return type
     * @param path the dot-notation path to the value
     * @param type the class of the expected type
     * @return the value at the specified path, or null if not found
     */
    <T> T getArenaData(String path, Class<T> type);

    /**
     * Gets a location from game configuration data.
     * <p>
     * Automatically deserializes the JSON object at the path into a platform location.
     * </p>
     *
     * @param path the dot-notation path to the location data
     * @return the location object, or null if not found
     */
    L getGameLocation(String path);

    /**
     * Gets a location from arena configuration data.
     * <p>
     * Automatically deserializes the JSON object at the path into a platform location.
     * </p>
     *
     * @param path the dot-notation path to the location data
     * @return the location object, or null if not found
     */
    L getArenaLocation(String path);

    /**
     * Checks if a path exists in the game configuration.
     *
     * @param path the dot-notation path to check
     * @return true if the path exists, false otherwise
     */
    boolean hasGameData(String path);

    /**
     * Checks if a path exists in the arena configuration.
     *
     * @param path the dot-notation path to check
     * @return true if the path exists, false otherwise
     */
    boolean hasArenaData(String path);
}
