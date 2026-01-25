package net.blueva.arcade.api.config;

import java.io.File;
import java.util.List;

/**
 * API for managing multiple configuration files per module.
 * Each module can have settings.yml, items.yml, rewards.yml, etc.
 *
 * Uses BoostedYaml internally (no dependency needed in modules).
 */
public interface ModuleConfigAPI {

    /**
     * Register a config file for this module.
     * Creates it from embedded resource if it doesn't exist.
     *
     * @param fileName Config file name (e.g., "settings.yml", "items.yml")
     * @return true if registered successfully
     */
    boolean register(String fileName);

    /**
     * Register a config with custom file version for auto-updates.
     *
     * @param fileName Config file name
     * @param fileVersion Version for auto-update system
     * @return true if registered successfully
     */
    boolean register(String fileName, int fileVersion);

    /**
     * Reload a specific config file.
     *
     * @param fileName Config file name
     */
    void reload(String fileName);

    /**
     * Reload all registered configs.
     */
    void reloadAll();

    /**
     * Save a specific config file.
     *
     * @param fileName Config file name
     */
    void save(String fileName);

    /**
     * Save all registered configs.
     */
    void saveAll();

    /**
     * Check if a config file is registered.
     *
     * @param fileName Config file name
     * @return true if registered
     */
    boolean isRegistered(String fileName);

    /**
     * Get module's data folder.
     *
     * @return Module folder (plugins/BlueArcade/modules/{moduleId}/)
     */
    File getDataFolder();

    /**
     * Get list of all registered config file names.
     *
     * @return List of registered config files
     */
    List<String> getRegisteredConfigs();

    // ===== UTILITY METHODS (from main settings.yml) =====

    /**
     * Get string from main settings.yml
     *
     * @param path Config path
     * @return String value
     */
    String getString(String path);

    /**
     * Get string with default from settings.yml
     */
    String getString(String path, String def);

    /**
     * Get int from settings.yml
     */
    int getInt(String path);

    /**
     * Get int with default from settings.yml
     */
    int getInt(String path, int def);

    /**
     * Get double from settings.yml
     */
    double getDouble(String path);

    /**
     * Get double with default from settings.yml
     */
    double getDouble(String path, double def);

    /**
     * Get boolean from settings.yml
     */
    boolean getBoolean(String path);

    /**
     * Get boolean with default from settings.yml
     */
    boolean getBoolean(String path, boolean def);

    /**
     * Get string list from settings.yml
     */
    List<String> getStringList(String path);

    /**
     * Check if path exists in settings.yml
     */
    boolean contains(String path);

    // ===== SPECIFIC CONFIG METHODS =====

    /**
     * Get string from a specific config file.
     *
     * @param fileName Config file name
     * @param path Config path
     * @return String value
     */
    String getStringFrom(String fileName, String path);

    /**
     * Get string with default from a specific config file.
     */
    String getStringFrom(String fileName, String path, String def);

    /**
     * Get int from a specific config file.
     */
    int getIntFrom(String fileName, String path);

    /**
     * Get int with default from a specific config file.
     */
    int getIntFrom(String fileName, String path, int def);

    /**
     * Get double from a specific config file.
     */
    double getDoubleFrom(String fileName, String path);

    /**
     * Get double with default from a specific config file.
     */
    double getDoubleFrom(String fileName, String path, double def);

    /**
     * Get boolean from a specific config file.
     */
    boolean getBooleanFrom(String fileName, String path);

    /**
     * Get boolean with default from a specific config file.
     */
    boolean getBooleanFrom(String fileName, String path, boolean def);

    /**
     * Get list from a specific config file.
     */
    List<String> getStringListFrom(String fileName, String path);

    /**
     * Check if path exists in a specific config file.
     */
    boolean containsFrom(String fileName, String path);

    // ===== SET METHODS (for runtime modification) =====

    /**
     * Set value in settings.yml
     */
    void set(String path, Object value);

    /**
     * Set value in a specific config file.
     */
    void setIn(String fileName, String path, Object value);
}
