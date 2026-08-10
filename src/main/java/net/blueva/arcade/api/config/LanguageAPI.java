package net.blueva.arcade.api.config;

import java.util.Arrays;

import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * Locale-aware translation API for core and module messages.
 *
 * @param <P> platform player type
 * @since 3.4
 */
public interface LanguageAPI<P> {

    /**
     * Resolve the locale that should be used for a player right now.
     * Implementations may combine a manual player override, client auto-detection,
     * server default locale, and fallback locale.
     *
     * @param player platform player, or {@code null} to use the server default locale
     * @return effective locale code
     */
    String getEffectiveLocale(P player);

    /**
     * Return the manually stored player locale override, if one exists.
     * This does not include client auto-detection or server defaults.
     *
     * @param player platform player
     * @return manual locale code, or {@code null} when the player uses automatic/default resolution
     */
    default String getManualLocale(P player) {
        return null;
    }

    /**
     * Store a manual locale override for a player.
     *
     * @param player platform player
     * @param locale locale code
     */
    void setManualLocale(P player, String locale);

    /**
     * Clear a player's manual locale override so automatic/default resolution is used again.
     *
     * @param player platform player
     */
    default void clearManualLocale(P player) {
    }

    /**
     * @deprecated use {@link #getEffectiveLocale(Object)} for the active locale or
     * {@link #getManualLocale(Object)} for the stored manual override.
     */
    @Deprecated
    default String getPlayerLocale(P player) {
        return getEffectiveLocale(player);
    }

    /**
     * @deprecated use {@link #setManualLocale(Object, String)}.
     */
    @Deprecated
    default void setPlayerLocale(P player, String locale) {
        setManualLocale(player, locale);
    }

    /**
     * @deprecated use {@link #clearManualLocale(Object)}.
     */
    @Deprecated
    default void clearPlayerLocale(P player) {
        clearManualLocale(player);
    }

    String getDefaultLocale();

    /**
     * Final fallback locale used when the player and server default locales do not contain a translation.
     * {@code en} is recommended because the Core defaults are authored in English.
     */
    default String getFallbackLocale() {
        return "en";
    }

    /**
     * Register a module translation file with the runtime.
     * <p>
     * Normal modules should not call this. Core runtimes auto-discover
     * {@code files/language/<locale>.yml} resources and register them internally.
     * This method remains public only for custom runtime adapters.
     * </p>
     */
    void registerModuleTranslation(String moduleId, String locale, String resourcePath);

    String translate(P player, String moduleId, String key);

    String translate(P player, String moduleId, String key, String... placeholders);

    default String translate(P player, String moduleId, String key, Map<String, String> placeholders) {
        String value = translate(player, moduleId, key);
        return Placeholders.replace(value, placeholders);
    }

    default String translateOrDefault(P player, String moduleId, String key, String defaultValue) {
        String value = translate(player, moduleId, key);
        return value == null || value.equals(key) ? defaultValue : value;
    }

    default String translateOrDefault(P player, String moduleId, String key, String defaultValue, String... placeholders) {
        return Placeholders.replace(translateOrDefault(player, moduleId, key, defaultValue), placeholders);
    }

    default String translateOrDefault(P player, String moduleId, String key, String defaultValue, Map<String, String> placeholders) {
        return Placeholders.replace(translateOrDefault(player, moduleId, key, defaultValue), placeholders);
    }

    /**
     * Look up a translated string list for module UI such as scoreboards, lore, and result messages.
     *
     * @since 3.4
     */
    default List<String> translateList(P player, String moduleId, String key) {
        String value = translate(player, moduleId, key);
        return value == null || value.equals(key) ? Collections.<String>emptyList() : Collections.singletonList(value);
    }

    /**
     * Look up a translated string list and replace MiniMessage placeholder tokens.
     * Placeholders are passed as pairs: {@code "{name}", "value"}.
     *
     * @since 3.4
     */
    default List<String> translateList(P player, String moduleId, String key, String... placeholders) {
        List<String> values = translateList(player, moduleId, key);
        if (placeholders == null || placeholders.length == 0 || values.isEmpty()) {
            return values;
        }
        return values.stream().map(value -> Placeholders.replace(value, placeholders)).collect(Collectors.toList());
    }

    default List<String> translateList(P player, String moduleId, String key, Map<String, String> placeholders) {
        List<String> values = translateList(player, moduleId, key);
        if (placeholders == null || placeholders.isEmpty() || values.isEmpty()) {
            return values;
        }
        return values.stream().map(value -> Placeholders.replace(value, placeholders)).collect(Collectors.toList());
    }

    default List<String> translateListOrDefault(P player, String moduleId, String key, List<String> defaultValue) {
        List<String> values = translateList(player, moduleId, key);
        return values == null || values.isEmpty() ? defaultValue : values;
    }

    default List<String> translateListOrDefault(P player, String moduleId, String key, List<String> defaultValue, String... placeholders) {
        return translateListOrDefault(player, moduleId, key, defaultValue).stream()
                .map(value -> Placeholders.replace(value, placeholders))
                .collect(Collectors.toList());
    }

    default List<String> translateListOrDefault(P player, String moduleId, String key, List<String> defaultValue, Map<String, String> placeholders) {
        return translateListOrDefault(player, moduleId, key, defaultValue).stream()
                .map(value -> Placeholders.replace(value, placeholders))
                .collect(Collectors.toList());
    }

    boolean hasTranslation(String moduleId, String locale, String key);

    List<String> getModuleLocales(String moduleId);

    /**
     * Return locale codes currently available from Core and loaded modules.
     * This is intended for validation and command suggestions.
     *
     * @return available locale codes
     * @since 3.4
     */
    default List<String> getAvailableLocales() {
        String defaultLocale = getDefaultLocale();
        String fallbackLocale = getFallbackLocale();
        if (defaultLocale == null || defaultLocale.equals(fallbackLocale)) {
            return fallbackLocale == null ? Collections.<String>emptyList() : Collections.singletonList(fallbackLocale);
        }
        return Arrays.asList(defaultLocale, fallbackLocale);
    }

    /**
     * Check whether a locale can be selected. Implementations may normalize
     * Minecraft locale tags such as {@code es_es} or {@code es-ES} to {@code es}.
     *
     * @param locale requested locale code
     * @return true if the locale is available
     * @since 3.4
     */
    default boolean isLocaleAvailable(String locale) {
        return locale != null && getAvailableLocales().contains(locale);
    }


}
