package net.blueva.arcade.api.ui;

/**
 * Handles module-scoped actions triggered from Hytale custom UI menus.
 * <p>
 * This callback is used by the experimental Hytale menu API to dispatch
 * actions declared with the {@code MODULE;} action target.
 * </p>
 *
 * @param <P> player type
 * @since 3.2
 */
@FunctionalInterface
public interface HytaleMenuActionHandler<P> {

    /**
     * Called when a MODULE action is triggered from a Hytale menu.
     *
     * @param player the player that triggered the action
     * @param payload custom payload declared in the menu action string
     */
    void handle(P player, String payload);
}
