package net.blueva.arcade.api.stats;

import java.util.Locale;

/**
 * Represents time periods for statistic tracking and leaderboards.
 * <p>
 * Stat periods allow tracking player performance over different time frames,
 * enabling both historical all-time records and current seasonal competitions.
 * </p>
 */
public enum StatPeriod {
    /**
     * All-time statistics tracking from the beginning.
     * <p>
     * This period includes all historical data without any time restrictions.
     * Used for lifetime achievement tracking and permanent leaderboards.
     * </p>
     */
    ALLTIME("alltime"),

    /**
     * Yearly statistics that reset annually.
     * <p>
     * Tracks performance within the current calendar year.
     * Used for annual seasons and yearly competitions.
     * </p>
     */
    YEARLY("yearly"),

    /**
     * Monthly statistics that reset each month.
     * <p>
     * Tracks performance within the current calendar month.
     * Used for monthly competitions and short-term leaderboards.
     * </p>
     */
    MONTHLY("monthly");

    private final String id;

    StatPeriod(String id) {
        this.id = id;
    }

    /**
     * Gets the string identifier for this period.
     *
     * @return the period ID
     */
    public String id() {
        return id;
    }

    /**
     * Parses a stat period from its string ID.
     *
     * @param input the period ID string (case-insensitive)
     * @return the matching StatPeriod, or null if not found
     */
    public static StatPeriod fromId(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }
        String normalized = input.trim().toLowerCase(Locale.ROOT);
        for (StatPeriod period : values()) {
            if (period.id.equals(normalized)) {
                return period;
            }
        }
        return null;
    }
}
