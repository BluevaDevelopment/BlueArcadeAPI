package net.blueva.arcade.api.utils;

/**
 * Utility methods for platform-agnostic location operations.
 */
public class LocationUtil {

    /**
     * Check if location is between two bounds.
     */
    public static <L, W> boolean isBetween(L loc, L min, L max, LocationAdapter<L, W> adapter) {
        return adapter.getX(loc) >= adapter.getX(min) && adapter.getX(loc) <= adapter.getX(max)
                && adapter.getY(loc) >= adapter.getY(min) && adapter.getY(loc) <= adapter.getY(max)
                && adapter.getZ(loc) >= adapter.getZ(min) && adapter.getZ(loc) <= adapter.getZ(max);
    }

    /**
     * Get center of two locations.
     */
    public static <L, W> L getCenter(L min, L max, LocationAdapter<L, W> adapter) {
        double x = (adapter.getX(min) + adapter.getX(max)) / 2;
        double y = (adapter.getY(min) + adapter.getY(max)) / 2;
        double z = (adapter.getZ(min) + adapter.getZ(max)) / 2;
        return adapter.create(adapter.getWorld(min), x, y, z);
    }

    /**
     * Format location as string.
     */
    public static <L, W> String toString(L loc, LocationAdapter<L, W> adapter) {
        return String.format("%.2f, %.2f, %.2f",
                adapter.getX(loc),
                adapter.getY(loc),
                adapter.getZ(loc));
    }
}
