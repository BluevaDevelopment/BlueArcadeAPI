package net.blueva.arcade.api.world;

/**
 * Represents a 3D rectangular region in the world.
 * <p>
 * World regions define cuboid areas used for arena bounds, protected zones,
 * or game-specific areas. They are defined by two corner points (min and max)
 * and provide utilities for containment checks and geometric calculations.
 * </p>
 *
 * @param <L> the location type (platform-specific)
 * @param <W> the world type (platform-specific)
 */
public interface WorldRegion<L, W> {

    /**
     * Gets the world this region is located in.
     *
     * @return the world
     */
    W getWorld();

    /**
     * Gets the minimum corner point of this region.
     * <p>
     * This typically represents the corner with smallest X, Y, Z coordinates.
     * </p>
     *
     * @return the minimum boundary location
     */
    L getMin();

    /**
     * Gets the maximum corner point of this region.
     * <p>
     * This typically represents the corner with largest X, Y, Z coordinates.
     * </p>
     *
     * @return the maximum boundary location
     */
    L getMax();

    /**
     * Checks if a location is within this region's boundaries.
     *
     * @param loc the location to check
     * @return true if the location is inside the region, false otherwise
     */
    boolean contains(L loc);

    /**
     * Calculates the volume of this region in cubic blocks.
     *
     * @return the volume (width × height × depth)
     */
    int getVolume();

    /**
     * Gets the center point of this region.
     *
     * @return the center location
     */
    L getCenter();
}
