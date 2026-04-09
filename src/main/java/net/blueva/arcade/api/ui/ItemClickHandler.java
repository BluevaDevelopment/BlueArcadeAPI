package net.blueva.arcade.api.ui;

/**
 * Functional interface for custom lobby item click handling.
 * Register instances via {@link ItemAPI#registerClickHandler(String, ItemClickHandler)}.
 *
 * @param <P> Player type
 * @since 3.3
 */
@FunctionalInterface
public interface ItemClickHandler<P> {

    /**
     * Handle an item-click event.
     *
     * @param player Player who clicked the item
     * @return {@code true} if the click was handled successfully
     */
    boolean handleClick(P player);
}
