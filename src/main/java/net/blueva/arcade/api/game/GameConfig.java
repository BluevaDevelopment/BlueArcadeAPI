package net.blueva.arcade.api.game;

/**
 * Represents the configuration for a game module.
 * <p>
 * This interface provides access to core game settings including player limits,
 * time constraints, death mechanics, and required arena components.
 * Implementations define game-specific requirements that must be met for the
 * arena to be playable.
 * </p>
 *
 * @param <M> the material/block type (platform-specific)
 */
public interface GameConfig<M> {

    /**
     * Gets the unique identifier of this game module.
     *
     * @return the game module ID
     */
    String getGameId();

    /**
     * Gets the default time limit for this game.
     * <p>
     * The meaning and units may vary by game (e.g., seconds, ticks).
     * </p>
     *
     * @return the default time value
     */
    int getTime();

    /**
     * Gets the minimum number of players required to start this game.
     *
     * @return the minimum player count
     */
    int getMinPlayers();

    /**
     * Gets the maximum number of players allowed in this game.
     *
     * @return the maximum player count
     */
    int getMaxPlayers();

    /**
     * Gets the block type that triggers player death/elimination.
     * <p>
     * This is commonly used for void blocks, lava, or other hazards.
     * </p>
     *
     * @return the death block material, or null if not applicable
     */
    M getDeathBlock();

    /**
     * Checks if this game requires arena boundaries to be configured.
     *
     * @return true if bounds configuration is required, false otherwise
     */
    boolean requiresBounds();

    /**
     * Checks if this game requires spawn points to be configured.
     *
     * @return true if spawns configuration is required, false otherwise
     */
    boolean requiresSpawns();

    /**
     * Checks if this game requires a finish line to be configured.
     * <p>
     * This is typically used for race-type games.
     * </p>
     *
     * @return true if finish line configuration is required, false otherwise
     */
    boolean requiresFinishLine();

    /**
     * Checks if this game requires floor regions to be configured.
     * <p>
     * This is typically used for games like Block Party or TNT Run.
     * </p>
     *
     * @return true if floors configuration is required, false otherwise
     */
    boolean requiresFloors();
}
