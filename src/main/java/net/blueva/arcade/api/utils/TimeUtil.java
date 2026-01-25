package net.blueva.arcade.api.utils;

/**
 * Utility methods for time formatting.
 */
public class TimeUtil {

    /**
     * Format seconds to MM:SS.
     */
    public static String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }

    /**
     * Format seconds to readable string (e.g., "5m 30s").
     */
    public static String formatReadable(int seconds) {
        if (seconds < 60) {
            return seconds + "s";
        }
        int minutes = seconds / 60;
        int secs = seconds % 60;
        if (secs == 0) {
            return minutes + "m";
        }
        return minutes + "m " + secs + "s";
    }
}
