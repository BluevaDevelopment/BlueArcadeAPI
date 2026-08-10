package net.blueva.arcade.api.module;

import java.util.List;

/**
 * Read-only access to module metadata from module.yml.
 * Automatically provided to modules through ModuleAPI.
 */
public interface ModuleInfo {

    /**
     * Get the module's unique identifier.
     * @return Module ID (e.g., "race")
     */
    String getId();

    /**
     * Get the module's display name.
     * @return Module name (e.g., "Race")
     */
    String getName();

    /**
     * Get the module's version.
     * @return Version string (e.g., "1.0.0")
     */
    String getVersion();

    /**
     * Get the module's type.
     * @return Module type (MINIGAME or MICROGAME)
     */
    ModuleType getType();

    /**
     * Get the module's authors.
     * @return List of author names
     */
    List<String> getAuthors();

    /**
     * Get the module's description.
     * @return Description or empty string
     */
    String getDescription();

    /**
     * Get the module's website.
     * @return Website URL or null
     */
    String getWebsite();

    /**
     * Get the module's API version.
     * @return API version string
     */
    String getApiVersion();

    /**
     * Get the module's soft dependencies.
     * @return List of soft dependency module IDs
     */
    List<String> getSoftDepend();

    /**
     * Get the target platform declared in {@code module.yml}.
     * <p>
     * When the {@code platform} field is absent from the descriptor the module
     * is considered cross-platform and this method returns {@code null}.
     * </p>
     *
     * @return the target platform, or {@code null} if not declared (cross-platform)
     * @since 3.2
     */
    default PlatformType getPlatform() {
        return null;
    }

    /**
     * Get the minimum server version this module supports, as declared by the
     * {@code game-version} field in {@code module.yml}.
     * <p>
     * The value is a plain version string of the target platform's own versioning scheme
     * (e.g. {@code "1.16"} on Minecraft) and means "this module runs on that version and any
     * newer one" - there is no upper bound. A module that omits the field declares no minimum
     * and this method returns {@code null}.
     * </p>
     *
     * @return the minimum supported server version, or {@code null} if not declared
     * @since 3.5
     */
    default String getGameVersion() {
        return null;
    }
}
