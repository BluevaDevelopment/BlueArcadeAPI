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
public record StoreItemDefinition<M>(
        String id,
        String displayName,
        M icon,
        List<String> description,
        int price,
        boolean enabled,
        boolean defaultUnlocked
) {
}
