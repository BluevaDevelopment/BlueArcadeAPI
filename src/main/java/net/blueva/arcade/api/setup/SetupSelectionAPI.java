package net.blueva.arcade.api.setup;

/**
 * API for retrieving player position selections during arena setup.
 * <p>
 * Players use a selection tool (magic stick) to mark two positions (corners) for defining
 * regions, bounds, or other spatial game configuration. This API provides access to those
 * selections. Available from {@link SetupContext}.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 * @param <L> the location type (platform-specific)
 */
public interface SetupSelectionAPI<P, L> {

    /**
     * Checks if a player has selected both positions (pos1 and pos2).
     *
     * @param player the player to check
     * @return true if the player has both positions selected, false otherwise
     */
    boolean hasCompleteSelection(P player);

    /**
     * Gets the player's first selected position.
     *
     * @param player the player
     * @return the first position, or null if not selected
     */
    L getPosition1(P player);

    /**
     * Gets the player's second selected position.
     *
     * @param player the player
     * @return the second position, or null if not selected
     */
    L getPosition2(P player);
}
