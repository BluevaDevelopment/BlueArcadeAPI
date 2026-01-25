package net.blueva.arcade.api.ui;

import java.util.List;
import java.util.Map;

/**
 * API for managing game scoreboards.
 * Supports module-specific scoreboards with automatic placeholder resolution.
 */
public interface ScoreboardAPI<P> {

    /**
     * Update scoreboard for player using module's scoreboard configuration.
     * Automatically resolves placeholders from:
     * - Core placeholders ({arena}, {round}, {time}, etc.)
     * - Module custom placeholders
     *
     * @param player Player to update
     */
    void update(P player);

    /**
     * Update scoreboard with custom placeholders.
     *
     * @param player Player
     * @param placeholders Additional placeholders to add/override
     */
    void update(P player, Map<String, String> placeholders);

    /**
     * Update scoreboard for player using custom scoreboard path.
     *
     * @param player Player to update
     * @param scoreboardPath Path to scoreboard config (e.g., "scoreboard", "scoreboards.team_red")
     */
    void update(P player, String scoreboardPath);

    /**
     * Update scoreboard with custom path and placeholders.
     */
    void update(P player, String scoreboardPath, Map<String, String> placeholders);

    /**
     * Show custom scoreboard to player using specified path.
     */
    void showScoreboard(P player, String scoreboardPath);

    /**
     * Set custom scoreboard title.
     *
     * @param player Player
     * @param title Formatted title
     */
    void setTitle(P player, String title);

    /**
     * Set custom scoreboard lines directly.
     *
     * @param player Player
     * @param lines List of formatted lines
     */
    void setLines(P player, List<String> lines);

    /**
     * Remove scoreboard from player.
     *
     * @param player Player
     */
    void remove(P player);

    /**
     * Show module-specific scoreboard to player.
     * Loads title and lines from module's language file.
     *
     * @param player Player
     */
    void showModuleScoreboard(P player);

    /**
     * Show a module-defined final scoreboard to the player using the provided path.
     * Intended for end-of-game views (e.g., team outcomes) that should override the default finish scoreboard.
     *
     * @param player Player
     * @param scoreboardPath Path in the module language file (e.g., "scoreboard.final.team_win")
     */
    void showModuleFinalScoreboard(P player, String scoreboardPath);

    /**
     * Show a module-defined final scoreboard with custom placeholders.
     *
     * @param player Player
     * @param scoreboardPath Path in the module language file
     * @param placeholders Additional placeholders to add/override
     */
    void showModuleFinalScoreboard(P player, String scoreboardPath, Map<String, String> placeholders);

    /**
     * Clear any pending final-scoreboard override for the player.
     *
     * @param player Player
     */
    void clearFinalScoreboard(P player);
}
