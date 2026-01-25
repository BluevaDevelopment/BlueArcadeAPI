package net.blueva.arcade.api.ui;

@FunctionalInterface
public interface ModuleActionHandler<P> {

    /**
     * Handle a module action.
     *
     * @param player  player who triggered the action
     * @param payload action payload
     * @return true if handled, false otherwise
     */
    boolean handle(P player, String payload);
}
