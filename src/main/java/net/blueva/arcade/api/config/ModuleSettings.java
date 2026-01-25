package net.blueva.arcade.api.config;

import java.util.List;

/**
 * Provides access to module-specific settings from settings.yml
 * <p>
 * This interface allows game modules to read configuration values from their
 * settings.yml file using dot-notation paths. Supports common data types and
 * provides default value overloads for safe configuration reading.
 * </p>
 *
 * @deprecated Use {@link ModuleConfigAPI} instead for better flexibility
 */
@Deprecated
public interface ModuleSettings {

    /**
     * Gets a string value from the configuration.
     *
     * @param path the dot-notation path to the value
     * @return the string value, or null if not found
     */
    String getString(String path);

    /**
     * Gets a string value with a default fallback.
     *
     * @param path the dot-notation path to the value
     * @param def the default value if path not found
     * @return the string value, or the default if not found
     */
    String getString(String path, String def);

    /**
     * Gets an integer value from the configuration.
     *
     * @param path the dot-notation path to the value
     * @return the integer value, or 0 if not found
     */
    int getInt(String path);

    /**
     * Gets an integer value with a default fallback.
     *
     * @param path the dot-notation path to the value
     * @param def the default value if path not found
     * @return the integer value, or the default if not found
     */
    int getInt(String path, int def);

    /**
     * Gets a double value from the configuration.
     *
     * @param path the dot-notation path to the value
     * @return the double value, or 0.0 if not found
     */
    double getDouble(String path);

    /**
     * Gets a double value with a default fallback.
     *
     * @param path the dot-notation path to the value
     * @param def the default value if path not found
     * @return the double value, or the default if not found
     */
    double getDouble(String path, double def);

    /**
     * Gets a boolean value from the configuration.
     *
     * @param path the dot-notation path to the value
     * @return the boolean value, or false if not found
     */
    boolean getBoolean(String path);

    /**
     * Gets a boolean value with a default fallback.
     *
     * @param path the dot-notation path to the value
     * @param def the default value if path not found
     * @return the boolean value, or the default if not found
     */
    boolean getBoolean(String path, boolean def);

    /**
     * Gets a list of strings from the configuration.
     *
     * @param path the dot-notation path to the list
     * @return the string list, or an empty list if not found
     */
    List<String> getStringList(String path);

    /**
     * Checks if a configuration path exists.
     *
     * @param path the dot-notation path to check
     * @return true if the path exists, false otherwise
     */
    boolean contains(String path);
}
