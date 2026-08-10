package net.blueva.arcade.api.ui.menu.minecraft;

/**
 * Menu item bound to a specific inventory slot for Minecraft Java Edition.
 *
 * @param <M> the material type (platform-specific)
 * @param slot the inventory slot (0-53)
 * @param item the item definition to display at this slot
 * @since 3.2
 */
public final class MCJavaMenuItem<M> {

    private final int slot;
    private final MCJavaItemDefinition<M> item;

    public MCJavaMenuItem(int slot, MCJavaItemDefinition<M> item) {
        this.slot = slot;
        this.item = item;
    }

    public int slot() {
        return this.slot;
    }

    public MCJavaItemDefinition<M> item() {
        return this.item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCJavaMenuItem)) {
            return false;
        }
        MCJavaMenuItem<?> other = (MCJavaMenuItem<?>) o;
        return this.slot == other.slot
            && java.util.Objects.equals(this.item, other.item);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(slot, item);
    }

    @Override
    public String toString() {
        return "MCJavaMenuItem[" +
            "slot=" + this.slot + ", " +
            "item=" + this.item +
            "]";
    }

    public static <M> MCJavaMenuItem<M> of(int slot, MCJavaItemDefinition<M> item) {
        return new MCJavaMenuItem<>(slot, item);
    }
}
