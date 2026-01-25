package net.blueva.arcade.api.store;

import java.util.List;

/**
 * API for registering and managing store categories/items.
 */
public interface StoreAPI<P, M> {

    /**
     * Register a category with its items.
     *
     * @param category Category definition
     * @param items Items available in the category
     */
    void registerCategory(StoreCategoryDefinition<M> category, List<StoreItemDefinition<M>> items);

    /**
     * Unregister a category by its id.
     *
     * @param categoryId Category id
     */
    void unregisterCategory(String categoryId);

    /**
     * Open the global store categories menu for the player.
     */
    boolean openStore(P player);

    /**
     * Open the store menu including module-specific categories.
     *
     * @param player Player to open for
     * @param moduleId Module id to include module-specific categories
     */
    boolean openStore(P player, String moduleId);

    /**
     * Open a specific category.
     */
    boolean openCategory(P player, String categoryId);

    /**
     * Check if an item is unlocked for a player.
     */
    boolean isUnlocked(P player, String categoryId, String itemId);

    /**
     * Unlock an item for a player.
     */
    boolean unlock(P player, String categoryId, String itemId);

    /**
     * Select an item for a player.
     */
    boolean select(P player, String categoryId, String itemId);

    /**
     * Get the selected item id for a category.
     */
    String getSelected(P player, String categoryId);

    /**
     * Get the effective selected item id, resolving random selections to a concrete unlocked item.
     *
     * @param player player to resolve for
     * @param categoryId category id
     * @return the resolved item id, or null if none is available
     */
    String resolveSelected(P player, String categoryId);
}
