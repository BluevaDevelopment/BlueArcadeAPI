package net.blueva.arcade.api.store;

import java.util.List;

/**
 * Defines a purchasable store item.
 * <p>
 * Store items represent cosmetics, effects, or other purchasable content that players
 * can buy using in-game currency. Items belong to categories and can be unlocked by
 * default or require purchase.
 * </p>
 *
 * @param <M> the material/icon type (platform-specific)
 * @param id the unique identifier of this item
 * @param displayName the user-friendly name displayed in the store interface
 * @param icon the icon/material representing this item in menus
 * @param description a list of description lines shown to players
 * @param price the cost of this item in coins (0 for free items)
 * @param enabled whether this item is currently active and available for purchase
 * @param defaultUnlocked whether players have this item unlocked by default without purchasing
 */
public final class StoreItemDefinition<M> {

    private final String id;
    private final String displayName;
    private final M icon;
    private final List<String> description;
    private final int price;
    private final boolean enabled;
    private final boolean defaultUnlocked;

    public StoreItemDefinition(String id, String displayName, M icon, List<String> description, int price, boolean enabled, boolean defaultUnlocked) {
        this.id = id;
        this.displayName = displayName;
        this.icon = icon;
        this.description = description;
        this.price = price;
        this.enabled = enabled;
        this.defaultUnlocked = defaultUnlocked;
    }

    public String id() {
        return this.id;
    }

    public String displayName() {
        return this.displayName;
    }

    public M icon() {
        return this.icon;
    }

    public List<String> description() {
        return this.description;
    }

    public int price() {
        return this.price;
    }

    public boolean enabled() {
        return this.enabled;
    }

    public boolean defaultUnlocked() {
        return this.defaultUnlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreItemDefinition)) {
            return false;
        }
        StoreItemDefinition<?> other = (StoreItemDefinition<?>) o;
        return java.util.Objects.equals(this.id, other.id)
            && java.util.Objects.equals(this.displayName, other.displayName)
            && java.util.Objects.equals(this.icon, other.icon)
            && java.util.Objects.equals(this.description, other.description)
            && this.price == other.price
            && this.enabled == other.enabled
            && this.defaultUnlocked == other.defaultUnlocked;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, displayName, icon, description, price, enabled, defaultUnlocked);
    }

    @Override
    public String toString() {
        return "StoreItemDefinition[" +
            "id=" + this.id + ", " +
            "displayName=" + this.displayName + ", " +
            "icon=" + this.icon + ", " +
            "description=" + this.description + ", " +
            "price=" + this.price + ", " +
            "enabled=" + this.enabled + ", " +
            "defaultUnlocked=" + this.defaultUnlocked +
            "]";
    }
}
