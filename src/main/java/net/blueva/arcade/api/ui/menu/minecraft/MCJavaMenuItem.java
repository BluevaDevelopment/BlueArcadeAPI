package net.blueva.arcade.api.ui.menu.minecraft;

/**
 * Menu item bound to a specific inventory slot for Minecraft Java Edition.
 *
 * @param <M> the material type (platform-specific)
 * @param slot the inventory slot (0-53)
 * @param item the item definition to display at this slot
 * @since 3.2
 */
public record MCJavaMenuItem<M>(int slot, MCJavaItemDefinition<M> item) {

    public static <M> MCJavaMenuItem<M> of(int slot, MCJavaItemDefinition<M> item) {
        return new MCJavaMenuItem<>(slot, item);
    }
}
