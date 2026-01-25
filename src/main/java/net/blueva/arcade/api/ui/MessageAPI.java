package net.blueva.arcade.api.ui;

import java.util.List;
import java.util.Map;

/**
 * API for sending formatted messages to players.
 */
public interface MessageAPI<P> {

    /**
     * Send a message from module's language file.
     */
    void send(P player, String key);

    /**
     * Send a message with placeholders.
     */
    void send(P player, String key, Map<String, String> placeholders);

    /**
     * Send a raw formatted message.
     */
    void sendRaw(P player, String message);

    /**
     * Send action bar message to player (formatted).
     */
    void sendActionBar(P player, String message);

    /**
     * Get message list from language file.
     */
    List<String> getList(String key);

    /**
     * Broadcast message to all players in the game.
     */
    void broadcast(String key);

    /**
     * Broadcast with placeholders.
     */
    void broadcast(String key, Map<String, String> placeholders);
}
