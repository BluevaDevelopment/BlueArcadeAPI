package net.blueva.arcade.api.setup;

import java.util.List;

/**
 * API for registering and executing game setup commands.
 * Modules use this to register their setup handlers during onLoad().
 */
public interface GameSetupAPI {

    /**
     * Register a setup handler for a game.
     * Should be called during module's onLoad().
     *
     * @param gameId Game ID from module.yml
     * @param handler The handler to register
     */
    void registerHandler(String gameId, GameSetupHandler handler);

    /**
     * Unregister a setup handler for a game.
     * Called automatically when module is unloaded.
     *
     * @param gameId Game ID to unregister
     */
    void unregisterHandler(String gameId);

    /**
     * Get registered handler for a game.
     *
     * @param gameId Game ID
     * @return Handler or null if not registered
     */
    GameSetupHandler getHandler(String gameId);

    /**
     * Get all registered game IDs.
     *
     * @return List of registered game IDs
     */
    List<String> getRegisteredGames();

    /**
     * Check if a game has a registered handler.
     *
     * @param gameId Game ID
     * @return true if handler is registered
     */
    boolean hasHandler(String gameId);

    /**
     * Execute a setup command.
     * Called by core command handler.
     *
     * @param context Command context
     * @return true if command was handled
     */
    <P, C, L> boolean executeSetup(SetupContext<P, C, L> context);

    /**
     * Get tab completion suggestions.
     * Called by core command handler.
     *
     * @param context Tab completion context
     * @return Tab completion result
     */
    TabCompleteResult completeSetup(TabCompleteContext context);
}
