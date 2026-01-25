package net.blueva.arcade.api.events;

/**
 * Registry for module-specific event listeners.
 * Listeners registered here are automatically unregistered when the game ends.
 */
public interface CustomEventRegistry<L, P> {

    /**
     * Register a listener for this game module.
     */
    void register(L listener);

    /**
     * Register a listener with specific priority.
     */
    void register(L listener, P priority);

    /**
     * Unregister all listeners for this game.
     */
    void unregisterAll();
}
