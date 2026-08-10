package net.blueva.arcade.api.config;

import java.util.Collections;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * API for managing multiple configuration files per module.
 * Each module can have settings.yml, items.yml, rewards.yml, etc.
 *
 * Uses the platform configuration backend internally (no YAML dependency needed in modules).
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
     * Register a config with legacy file-version compatibility.
     * Modern platform implementations ignore {@code fileVersion}; it is kept
     * only so modules compiled against BlueArcade 3.3 and older continue to
     * load without changes.
     *
     * @param fileName Config file name
     * @param fileVersion Legacy version hint
     * @return true if registered successfully
     * @deprecated since 3.4, use {@link #register(String)}. BlueArcade no longer
     * uses {@code file_version} / {@code file-version} metadata in module files.
     */
    @Deprecated
    boolean register(String fileName, int fileVersion);

    /**
     * Register a config file using a copy-if-missing strategy.
     * The bundled resource is copied to disk only when the user file does not exist.
     * After that the file is loaded as-is without merging with bundled defaults, so
     * any entries the admin deliberately removed are never restored.
     * <p>
     * The default implementation falls back to {@link #register(String)}.
     * Platform core implementations override this with the real copy-if-missing logic.
     *
     * @param fileName Config file name relative to the module data folder (e.g. "kits.yml")
     * @return true if the file was registered successfully
     * @since 3.3
     */
    default boolean registerCopyOnly(String fileName) {
        return register(fileName);
    }

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

    /**
     * Look up a translated string for this module using the runtime language API
     * when available.
     * <p>
     * The default implementation preserves legacy behavior by reading from the
     * module's single {@code language.yml} file.
     * </p>
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @return translated value or the raw key when missing
     * @since 3.4
     */
    default String getTranslation(Object player, String key) {
        String value = getStringFrom("language.yml", key);
        return value != null ? value : key;
    }

    /**
     * Look up a translated string and replace MiniMessage placeholder tokens.
     * Placeholders are passed as pairs: {@code "{name}", "value"}.
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @param placeholders placeholder pairs
     * @return translated value or the raw key when missing
     * @since 3.4
     */
    default String getTranslation(Object player, String key, String... placeholders) {
        return Placeholders.replace(getTranslation(player, key), placeholders);
    }

    /**
     * Look up a translated string and replace MiniMessage placeholder tokens.
     * Placeholder keys are used exactly as supplied, e.g. {@code "{name}"}.
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @param placeholders placeholder map
     * @return translated value or the raw key when missing
     * @since 3.4
     */
    default String getTranslation(Object player, String key, Map<String, String> placeholders) {
        return Placeholders.replace(getTranslation(player, key), placeholders);
    }

    /**
     * Look up a translated string and return a caller-provided fallback when missing.
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @param defaultValue fallback returned when the translation is missing
     * @return translated value or {@code defaultValue}
     * @since 3.4
     */
    default String getTranslationOrDefault(Object player, String key, String defaultValue) {
        String value = getTranslation(player, key);
        return value == null || value.equals(key) ? defaultValue : value;
    }

    default String getTranslationOrDefault(Object player, String key, String defaultValue, String... placeholders) {
        return Placeholders.replace(getTranslationOrDefault(player, key, defaultValue), placeholders);
    }

    default String getTranslationOrDefault(Object player, String key, String defaultValue, Map<String, String> placeholders) {
        return Placeholders.replace(getTranslationOrDefault(player, key, defaultValue), placeholders);
    }

    /**
     * Look up a translated string list for this module using the runtime language API
     * when available. This is intended for scoreboards, menu lore, multi-line result
     * messages, and other localized lists.
     * <p>
     * The default implementation preserves legacy behavior by reading from the
     * module's single {@code language.yml} file.
     * </p>
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @return translated list, or an empty list when missing
     * @since 3.4
     */
    default List<String> getTranslationList(Object player, String key) {
        List<String> value = getStringListFrom("language.yml", key);
        return value != null ? value : Collections.<String>emptyList();
    }

    /**
     * Look up a translated string list and replace MiniMessage placeholder tokens.
     * Placeholders are passed as pairs: {@code "{name}", "value"}.
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @param key translation key
     * @param placeholders placeholder pairs
     * @return translated list, or an empty list when missing
     * @since 3.4
     */
    default List<String> getTranslationList(Object player, String key, String... placeholders) {
        List<String> values = getTranslationList(player, key);
        if (placeholders == null || placeholders.length == 0 || values.isEmpty()) {
            return values;
        }
        return values.stream().map(value -> Placeholders.replace(value, placeholders)).collect(Collectors.toList());
    }

    default List<String> getTranslationList(Object player, String key, Map<String, String> placeholders) {
        List<String> values = getTranslationList(player, key);
        if (placeholders == null || placeholders.isEmpty() || values.isEmpty()) {
            return values;
        }
        return values.stream().map(value -> Placeholders.replace(value, placeholders)).collect(Collectors.toList());
    }

    default List<String> getTranslationListOrDefault(Object player, String key, List<String> defaultValue) {
        List<String> values = getTranslationList(player, key);
        return values == null || values.isEmpty() ? defaultValue : values;
    }

    default List<String> getTranslationListOrDefault(Object player, String key, List<String> defaultValue, String... placeholders) {
        return getTranslationListOrDefault(player, key, defaultValue).stream()
                .map(value -> Placeholders.replace(value, placeholders))
                .collect(Collectors.toList());
    }

    default List<String> getTranslationListOrDefault(Object player, String key, List<String> defaultValue, Map<String, String> placeholders) {
        return getTranslationListOrDefault(player, key, defaultValue).stream()
                .map(value -> Placeholders.replace(value, placeholders))
                .collect(Collectors.toList());
    }

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
