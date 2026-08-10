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
public final class StoreCategoryDefinition<M> {

    private final String id;
    private final String displayName;
    private final M icon;
    private final List<String> description;
    private final StoreScope scope;
    private final String parentCategoryId;
    private final StoreCategoryType type;
    private final String moduleId;
    private final boolean enabled;
    private final int sortOrder;
    private final boolean selectionEnabled;
    private final boolean randomSelectionEnabled;
    private final String randomItemDisplayName;
    private final M randomItemIcon;
    private final List<String> randomItemDescription;

    public StoreCategoryDefinition(String id, String displayName, M icon, List<String> description, StoreScope scope, String parentCategoryId, StoreCategoryType type, String moduleId, boolean enabled, int sortOrder, boolean selectionEnabled, boolean randomSelectionEnabled, String randomItemDisplayName, M randomItemIcon, List<String> randomItemDescription) {
        this.id = id;
        this.displayName = displayName;
        this.icon = icon;
        this.description = description;
        this.scope = scope;
        this.parentCategoryId = parentCategoryId;
        this.type = type;
        this.moduleId = moduleId;
        this.enabled = enabled;
        this.sortOrder = sortOrder;
        this.selectionEnabled = selectionEnabled;
        this.randomSelectionEnabled = randomSelectionEnabled;
        this.randomItemDisplayName = randomItemDisplayName;
        this.randomItemIcon = randomItemIcon;
        this.randomItemDescription = randomItemDescription;
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

    public StoreScope scope() {
        return this.scope;
    }

    public String parentCategoryId() {
        return this.parentCategoryId;
    }

    public StoreCategoryType type() {
        return this.type;
    }

    public String moduleId() {
        return this.moduleId;
    }

    public boolean enabled() {
        return this.enabled;
    }

    public int sortOrder() {
        return this.sortOrder;
    }

    public boolean selectionEnabled() {
        return this.selectionEnabled;
    }

    public boolean randomSelectionEnabled() {
        return this.randomSelectionEnabled;
    }

    public String randomItemDisplayName() {
        return this.randomItemDisplayName;
    }

    public M randomItemIcon() {
        return this.randomItemIcon;
    }

    public List<String> randomItemDescription() {
        return this.randomItemDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreCategoryDefinition)) {
            return false;
        }
        StoreCategoryDefinition<?> other = (StoreCategoryDefinition<?>) o;
        return java.util.Objects.equals(this.id, other.id)
            && java.util.Objects.equals(this.displayName, other.displayName)
            && java.util.Objects.equals(this.icon, other.icon)
            && java.util.Objects.equals(this.description, other.description)
            && java.util.Objects.equals(this.scope, other.scope)
            && java.util.Objects.equals(this.parentCategoryId, other.parentCategoryId)
            && java.util.Objects.equals(this.type, other.type)
            && java.util.Objects.equals(this.moduleId, other.moduleId)
            && this.enabled == other.enabled
            && this.sortOrder == other.sortOrder
            && this.selectionEnabled == other.selectionEnabled
            && this.randomSelectionEnabled == other.randomSelectionEnabled
            && java.util.Objects.equals(this.randomItemDisplayName, other.randomItemDisplayName)
            && java.util.Objects.equals(this.randomItemIcon, other.randomItemIcon)
            && java.util.Objects.equals(this.randomItemDescription, other.randomItemDescription);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, displayName, icon, description, scope, parentCategoryId, type, moduleId, enabled, sortOrder, selectionEnabled, randomSelectionEnabled, randomItemDisplayName, randomItemIcon, randomItemDescription);
    }

    @Override
    public String toString() {
        return "StoreCategoryDefinition[" +
            "id=" + this.id + ", " +
            "displayName=" + this.displayName + ", " +
            "icon=" + this.icon + ", " +
            "description=" + this.description + ", " +
            "scope=" + this.scope + ", " +
            "parentCategoryId=" + this.parentCategoryId + ", " +
            "type=" + this.type + ", " +
            "moduleId=" + this.moduleId + ", " +
            "enabled=" + this.enabled + ", " +
            "sortOrder=" + this.sortOrder + ", " +
            "selectionEnabled=" + this.selectionEnabled + ", " +
            "randomSelectionEnabled=" + this.randomSelectionEnabled + ", " +
            "randomItemDisplayName=" + this.randomItemDisplayName + ", " +
            "randomItemIcon=" + this.randomItemIcon + ", " +
            "randomItemDescription=" + this.randomItemDescription +
            "]";
    }
}
