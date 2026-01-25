package net.blueva.arcade.api.ui;

import java.util.List;

/**
 * API for registering games in the vote menu system.
 */
public interface VoteMenuAPI<M> {

    /**
     * Register a game in the vote menu.
     *
     * @param gameId Game ID (e.g., "race")
     * @param material Material to display in menu
     * @param name Display name (supports MiniMessage format)
     * @param lore Lore lines (supports MiniMessage format and {votes} placeholder)
     */
    void registerGame(String gameId, M material, String name, List<String> lore);

    /**
     * Unregister a game from the vote menu.
     *
     * @param gameId Game ID
     */
    void unregisterGame(String gameId);

    /**
     * Check if a game is registered.
     *
     * @param gameId Game ID
     * @return true if registered
     */
    boolean isRegistered(String gameId);
}
