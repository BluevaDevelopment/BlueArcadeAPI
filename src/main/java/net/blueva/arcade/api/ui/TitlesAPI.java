package net.blueva.arcade.api.ui;

import java.util.Map;

/**
 * API for sending titles and subtitles to players.
 */
public interface TitlesAPI<P> {

    /**
     * Send title and subtitle from language config keys.
     */
    void send(P player, String titleKey, String subtitleKey, Map<String, String> placeholders);

    /**
     * Send title and subtitle with custom timings.
     */
    void send(P player, String titleKey, String subtitleKey, Map<String, String> placeholders, int fadeIn, int stay, int fadeOut);

    /**
     * Send raw title and subtitle (already formatted).
     */
    void sendRaw(P player, String title, String subtitle);

    /**
     * Send raw title and subtitle with custom timings.
     */
    void sendRaw(P player, String title, String subtitle, int fadeIn, int stay, int fadeOut);

    /**
     * Clear title for player.
     */
    void clear(P player);
}
