package net.blueva.arcade.api.utils;

/**
 * Adapter for platform-specific location implementations.
 * <p>
 * This adapter provides a platform-agnostic interface for working with locations
 * across different game platforms (Minecraft, Hytale, etc.).
 * </p>
 *
 * @param <L> the location type (platform-specific)
 * @param <W> the world type (platform-specific)
 */
public interface LocationAdapter<L, W> {

    /**
     * Gets the X coordinate of a location.
     *
     * @param location the location
     * @return the X coordinate
     */
    double getX(L location);

    /**
     * Gets the Y coordinate of a location.
     *
     * @param location the location
     * @return the Y coordinate
     */
    double getY(L location);

    /**
     * Gets the Z coordinate of a location.
     *
     * @param location the location
     * @return the Z coordinate
     */
    double getZ(L location);

    /**
     * Gets the world of a location.
     *
     * @param location the location
     * @return the world
     */
    W getWorld(L location);

    /**
     * Creates a new location from coordinates.
     *
     * @param world the world
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     * @return a new location instance
     */
    L create(W world, double x, double y, double z);
}
