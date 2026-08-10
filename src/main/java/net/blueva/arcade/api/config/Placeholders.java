package net.blueva.arcade.api.config;

import java.util.Map;

/**
 * Shared placeholder substitution for the translation helpers on {@link LanguageAPI} and
 * {@link ModuleConfigAPI}.
 *
 * <p>Package-private on purpose: this lives outside those interfaces only because Java 8, the
 * bytecode level the API targets so it loads on 1.8-1.16 servers, has no private interface
 * methods. It is not part of the public contract.</p>
 */
final class Placeholders {

    private Placeholders() {
    }

    static String replace(String value, String... placeholders) {
        if (value == null || placeholders == null) {
            return value;
        }
        String result = value;
        for (int i = 0; i + 1 < placeholders.length; i += 2) {
            result = result.replace(placeholders[i], placeholders[i + 1]);
        }
        return result;
    }

    static String replace(String value, Map<String, String> placeholders) {
        if (value == null || placeholders == null || placeholders.isEmpty()) {
            return value;
        }
        String result = value;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                result = result.replace(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
