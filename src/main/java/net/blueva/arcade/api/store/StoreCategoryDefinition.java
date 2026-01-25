package net.blueva.arcade.api.store;

import java.util.List;

/**
 * Defines a store category available for players.
 * <p>
 * Store categories organize purchasable items into logical groups. Categories can be
 * nested through parent-child relationships and can have different behaviors based on
 * their type (selection, purchase-only, or group).
 * </p>
 *
 * @param <M> the material/icon type (platform-specific)
 * @param id the unique identifier of this category
 * @param displayName the user-friendly name displayed in the store interface
 * @param icon the icon/material representing this category in menus
 * @param description a list of description lines shown to players
 * @param scope the visibility scope (GLOBAL for all games, MODULE for specific game)
 * @param parentCategoryId the ID of the parent category, or null if this is a root category
 * @param type the behavior type of this category (SELECTION, PURCHASE_ONLY, or GROUP)
 * @param moduleId the game module ID if scope is MODULE, or null for GLOBAL scope
 * @param enabled whether this category is currently active and visible to players
 * @param sortOrder the display order relative to other categories (lower values appear first)
 * @param selectionEnabled whether players can select an active item from this category
 * @param randomSelectionEnabled whether a "random" option is available for selection
 * @param randomItemDisplayName the display name for the random selection option
 * @param randomItemIcon the icon/material for the random selection option
 * @param randomItemDescription the description lines for the random selection option
 */
public record StoreCategoryDefinition<M>(
        String id,
        String displayName,
        M icon,
        List<String> description,
        StoreScope scope,
        String parentCategoryId,
        StoreCategoryType type,
        String moduleId,
        boolean enabled,
        int sortOrder,
        boolean selectionEnabled,
        boolean randomSelectionEnabled,
        String randomItemDisplayName,
        M randomItemIcon,
        List<String> randomItemDescription
) {
}
