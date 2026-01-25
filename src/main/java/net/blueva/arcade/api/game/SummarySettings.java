package net.blueva.arcade.api.game;

/**
 * Allows modules to configure how summaries and rewards behave for a game session.
 */
public interface SummarySettings {

    /**
     * @return {@code true} if per-round game summaries should be shown.
     */
    boolean isGameSummaryEnabled();

    /**
     * Enable or disable per-round game summaries.
     *
     * @param enabled whether to show the game summary
     */
    void setGameSummaryEnabled(boolean enabled);

    /**
     * @return {@code true} if the final summary should be shown at the end of the match.
     */
    boolean isFinalSummaryEnabled();

    /**
     * Enable or disable the final summary.
     *
     * @param enabled whether to show the final summary
     */
    void setFinalSummaryEnabled(boolean enabled);

    /**
     * @return {@code true} if rewards (credits, XP, stars) should be granted at the end of a round or match.
     */
    boolean areRewardsEnabled();

    /**
     * Enable or disable reward distribution.
     *
     * @param enabled whether to give rewards
     */
    void setRewardsEnabled(boolean enabled);
}
