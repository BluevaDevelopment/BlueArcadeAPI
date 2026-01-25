package net.blueva.arcade.api.ui.menu;

/**
 * Menu item bound to a specific inventory slot for Java edition.
 * <p>
 * Represents an item placed at a specific slot in a Java inventory menu.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param slot the inventory slot (0-53)
 * @param item the item definition to display at this slot
 */
public record JavaMenuItem<M>(int slot, JavaItemDefinition<M> item) {
    /**
     * Creates a new menu item at the specified slot.
     *
     * @param <M> the material type
     * @param slot the inventory slot
     * @param item the item definition
     * @return a new JavaMenuItem instance
     */
    public static <M> JavaMenuItem<M> of(int slot, JavaItemDefinition<M> item) {
        return new JavaMenuItem<>(slot, item);
    }
}
