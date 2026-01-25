package net.blueva.arcade.api.config;

import java.util.List;
import java.util.Map;

/**
 * API for accessing core plugin configuration files.
 * Provides access to settings.yml, messages.yml, sounds.yml, rewards.yml, etc.
 *
 * Uses BoostedYaml internally (no dependency needed in modules).
 */
public interface CoreConfigAPI {

    // ===== SETTINGS.YML =====

    /**
     * Get string from settings.yml
     */
    String getSettingsString(String path);

    /**
     * Get string with default from settings.yml
     */
    String getSettingsString(String path, String def);

    /**
     * Get int from settings.yml
     */
    int getSettingsInt(String path);

    /**
     * Get int with default from settings.yml
     */
    int getSettingsInt(String path, int def);

    /**
     * Get double from settings.yml
     */
    double getSettingsDouble(String path);

    /**
     * Get double with default from settings.yml
     */
    double getSettingsDouble(String path, double def);

    /**
     * Get boolean from settings.yml
     */
    boolean getSettingsBoolean(String path);

    /**
     * Get boolean with default from settings.yml
     */
    boolean getSettingsBoolean(String path, boolean def);

    /**
     * Get string list from settings.yml
     */
    List<String> getSettingsStringList(String path);

    /**
     * Check if path exists in settings.yml
     */
    boolean settingsContains(String path);

    // ===== LANGUAGE.YML (or language file) =====

    /**
     * Get message from messages/language file.
     *
     * @param key Message key (e.g., "messages.game_started")
     * @return Message string
     */
    String getLanguage(String key);

    /**
     * Get message with placeholders replaced.
     *
     * @param key Message key
     * @param placeholders Map of placeholders to replace (e.g., {player} -> "Steve")
     * @return Formatted message
     */
    String getLanguage(String key, Map<String, String> placeholders);

    /**
     * Get message list (for multi-line messages).
     *
     * @param key List key (e.g., "scoreboard.lines")
     * @return List of message lines
     */
    List<String> getLanguageList(String key);

    /**
     * Get message list with placeholders.
     */
    List<String> getLanguageList(String key, Map<String, String> placeholders);

    /**
     * Check if message key exists.
     */
    boolean hasLenguage(String key);

    // ===== SOUNDS.YML =====

    /**
     * Get sound path from sounds.yml
     *
     * @param key Sound key (e.g., "sounds.game_start")
     * @return Sound configuration string
     */
    String getSound(String key);

    /**
     * Get sound list (for random sounds).
     */
    List<String> getSoundList(String key);

    /**
     * Check if sound exists.
     */
    boolean hasSound(String key);

    // ===== REWARDS.YML =====

    /**
     * Get value from rewards.yml
     */
    String getRewardsString(String path);

    /**
     * Get int from rewards.yml
     */
    int getRewardsInt(String path);

    /**
     * Get int with default from rewards.yml
     */
    int getRewardsInt(String path, int def);

    /**
     * Get list from rewards.yml
     */
    List<String> getRewardsStringList(String path);

    /**
     * Check if path exists in rewards.yml
     */
    boolean rewardsContains(String path);

    // ===== GENERIC ACCESS (for any core config file) =====

    /**
     * Get string from any core config file.
     *
     * @param fileName Config file name (e.g., "settings.yml")
     * @param path Config path
     * @return String value
     */
    String getStringFrom(String fileName, String path);

    /**
     * Get string with default from any core config file.
     */
    String getStringFrom(String fileName, String path, String def);

    /**
     * Get int from any core config file.
     */
    int getIntFrom(String fileName, String path);

    /**
     * Get int with default from any core config file.
     */
    int getIntFrom(String fileName, String path, int def);

    /**
     * Get double from any core config file.
     */
    double getDoubleFrom(String fileName, String path);

    /**
     * Get double with default from any core config file.
     */
    double getDoubleFrom(String fileName, String path, double def);

    /**
     * Get boolean from any core config file.
     */
    boolean getBooleanFrom(String fileName, String path);

    /**
     * Get boolean with default from any core config file.
     */
    boolean getBooleanFrom(String fileName, String path, boolean def);

    /**
     * Get string list from any core config file.
     */
    List<String> getStringListFrom(String fileName, String path);

    /**
     * Check if path exists in any core config file.
     */
    boolean containsFrom(String fileName, String path);

    // ===== UTILITY =====

    /**
     * Reload all core configuration files.
     */
    void reloadAll();

    /**
     * Reload a specific core configuration file.
     */
    void reload(String fileName);
}
