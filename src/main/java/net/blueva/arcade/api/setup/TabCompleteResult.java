package net.blueva.arcade.api.setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Result of tab completion with suggestions.
 * Allows handlers to specify whether results should be auto-filtered.
 */
public class TabCompleteResult {

    private final List<String> suggestions;
    private final boolean autoFilter;

    private TabCompleteResult(List<String> suggestions, boolean autoFilter) {
        this.suggestions = suggestions != null ? suggestions : Collections.emptyList();
        this.autoFilter = autoFilter;
    }

    /**
     * Get the list of suggestions.
     */
    public List<String> getSuggestions() {
        return suggestions;
    }

    /**
     * Whether Bukkit should auto-filter results based on current input.
     * If true, Bukkit will filter suggestions starting with the typed text.
     * If false, all suggestions are returned as-is.
     */
    public boolean shouldAutoFilter() {
        return autoFilter;
    }

    /**
     * Get filtered suggestions if auto-filter is enabled.
     */
    public List<String> getFiltered(String currentArg) {
        if (!autoFilter || currentArg == null || currentArg.isEmpty()) {
            return suggestions;
        }

        String lower = currentArg.toLowerCase();
        return suggestions.stream()
                .filter(s -> s.toLowerCase().startsWith(lower))
                .collect(Collectors.toList());
    }

    // ===== BUILDERS =====

    /**
     * Create result with auto-filtering enabled.
     * Bukkit will automatically filter suggestions based on typed text.
     */
    public static TabCompleteResult of(List<String> suggestions) {
        return new TabCompleteResult(suggestions, true);
    }

    /**
     * Create result with auto-filtering enabled.
     */
    public static TabCompleteResult of(String... suggestions) {
        return new TabCompleteResult(Arrays.asList(suggestions), true);
    }

    /**
     * Create result without auto-filtering.
     * All suggestions are returned as-is.
     */
    public static TabCompleteResult raw(List<String> suggestions) {
        return new TabCompleteResult(suggestions, false);
    }

    /**
     * Create result without auto-filtering.
     */
    public static TabCompleteResult raw(String... suggestions) {
        return new TabCompleteResult(Arrays.asList(suggestions), false);
    }

    /**
     * Create empty result.
     */
    public static TabCompleteResult empty() {
        return new TabCompleteResult(Collections.emptyList(), true);
    }

    /**
     * Combine multiple results.
     * Auto-filter is enabled only if ALL results have it enabled.
     */
    public static TabCompleteResult combine(TabCompleteResult... results) {
        List<String> combined = new ArrayList<>();
        boolean allAutoFilter = true;

        for (TabCompleteResult result : results) {
            if (result != null) {
                combined.addAll(result.suggestions);
                allAutoFilter &= result.autoFilter;
            }
        }

        return new TabCompleteResult(combined, allAutoFilter);
    }
}
