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
}
