package net.blueva.arcade.api.config;

/**
 * API for accessing plugin configuration.
 */
public interface ConfigAPI {

    /**
     * Get a string from language config.
     */
    String getLanguageString(String path);

    /**
     * Get an integer from settings config.
     */
    int getSettingsInt(String path, int defaultValue);

    /**
     * Get a boolean from settings config.
     */
    boolean getSettingsBoolean(String path, boolean defaultValue);

    /**
     * Get a string from sounds config.
     */
    String getSoundsString(String path);
}
