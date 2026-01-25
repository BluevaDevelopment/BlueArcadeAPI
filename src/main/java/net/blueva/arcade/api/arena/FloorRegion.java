package net.blueva.arcade.api.arena;

/**
 * Represents a floor region in an arena defined by minimum and maximum boundary points.
 * <p>
 * A floor region is a rectangular area that can be used to define playable zones,
 * spawn areas, or other important game boundaries. The region is defined by two corner
 * points (min and max) that form a bounding box.
 * </p>
 *
 * @param <L> the location type (platform-specific)
 */
public interface FloorRegion<L> {

    /**
     * Gets the minimum boundary point of this region.
     * <p>
     * This typically represents the corner with the smallest X, Y, Z coordinates.
     * </p>
     *
     * @return the minimum boundary location
     */
    L getMin();

    /**
     * Gets the maximum boundary point of this region.
     * <p>
     * This typically represents the corner with the largest X, Y, Z coordinates.
     * </p>
     *
     * @return the maximum boundary location
     */
    L getMax();

    /**
     * Checks if a given location is within this floor region.
     *
     * @param loc the location to check
     * @return true if the location is within the region boundaries, false otherwise
     */
    boolean contains(L loc);
}
