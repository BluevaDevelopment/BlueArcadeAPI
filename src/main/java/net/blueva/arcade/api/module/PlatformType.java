package net.blueva.arcade.api.module;

import java.util.Locale;

/**
 * Identifies the server platform a module targets.
 * <p>
 * The recommended way for modules to declare their target platform is through
 * the {@code platform} field in {@code module.yml}. The core reads this value
 * from the module descriptor <b>before</b> loading the module class, so that
 * modules with platform-specific imports are never loaded on an incompatible
 * platform.
 * </p>
 * <p>
 * When the {@code platform} field is absent from {@code module.yml}, the
 * module is considered cross-platform (backward-compatible default for API
 * 3.1 modules).
 * </p>
 *
 * @since 3.2
 */
public enum PlatformType {

    /**
     * Minecraft (Spigot / Paper / Folia) servers.
     */
    MINECRAFT,

    /**
     * Hytale servers.
     */
    HYTALE;

    /**
     * Parses a platform type from a string (case-insensitive).
     *
     * @param raw the string to parse
     * @return the matching PlatformType, or {@code null} if not found
     */
    public static PlatformType fromString(String raw) {
        if (raw == null) {
            return null;
        }
        String normalized = raw.trim().toUpperCase(Locale.ROOT);
        for (PlatformType type : values()) {
            if (type.name().equals(normalized)) {
                return type;
            }
        }
        return null;
    }
}
