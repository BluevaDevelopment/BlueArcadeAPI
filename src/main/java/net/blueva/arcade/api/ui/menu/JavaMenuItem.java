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
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCJavaMenuItem} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class JavaMenuItem<M> {

    private final int slot;
    private final JavaItemDefinition<M> item;

    public JavaMenuItem(int slot, JavaItemDefinition<M> item) {
        this.slot = slot;
        this.item = item;
    }

    public int slot() {
        return this.slot;
    }

    public JavaItemDefinition<M> item() {
        return this.item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JavaMenuItem)) {
            return false;
        }
        JavaMenuItem<?> other = (JavaMenuItem<?>) o;
        return this.slot == other.slot
            && java.util.Objects.equals(this.item, other.item);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(slot, item);
    }

    @Override
    public String toString() {
        return "JavaMenuItem[" +
            "slot=" + this.slot + ", " +
            "item=" + this.item +
            "]";
    }

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
