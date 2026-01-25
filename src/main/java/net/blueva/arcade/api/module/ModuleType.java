package net.blueva.arcade.api.module;

import java.util.Locale;

/**
 * Declares the intended module gameplay duration and mode.
 * <p>
 * Module types categorize games by their expected duration and complexity.
 * This classification helps with scheduling, rewards, and player expectations.
 * </p>
 */
public enum ModuleType {
    /**
     * A standard minigame with typical duration of 2-10 minutes.
     * <p>
     * Minigames are full-featured games with complete mechanics, multiple rounds,
     * and comprehensive gameplay. Examples include SkyWars, BedWars, TNT Run, etc.
     * </p>
     */
    MINIGAME,

    /**
     * A quick microgame with duration under 2 minutes.
     * <p>
     * Microgames are fast-paced, simple games designed for rapid play sessions.
     * They typically have simplified mechanics and shorter rounds.
     * Examples include quick parkour challenges or fast reaction games.
     * </p>
     */
    MICROGAME;

    /**
     * Parses a module type from a string.
     *
     * @param raw the string to parse (case-insensitive)
     * @return the matching ModuleType, or null if not found
     */
    public static ModuleType fromString(String raw) {
        if (raw == null) {
            return null;
        }

        String normalized = raw.trim().toUpperCase(Locale.ROOT);
        for (ModuleType type : values()) {
            if (type.name().equals(normalized)) {
                return type;
            }
        }
        return null;
    }
}
