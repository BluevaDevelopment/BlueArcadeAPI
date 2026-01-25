package net.blueva.arcade.api.ui;

import java.util.List;
import java.util.Map;

/**
 * API for formatting and decorating items using the official color pipeline.
 * Also owns lobby item registration to avoid duplicate entry points.
 */
public interface ItemAPI<P, I, M> {

    /**
     * Register a waiting lobby item.
     *
     * @param item Lobby item definition
     */
    void registerWaitingItem(LobbyItemDefinition<M> item);

    /**
     * Register a waiting lobby item scoped to a specific module/game id.
     *
     * @param moduleId Module/game id that owns the item
     * @param item     Lobby item definition
     */
    default void registerWaitingItem(String moduleId, LobbyItemDefinition<M> item) {
        registerWaitingItem(item);
    }

    /**
     * Unregister a waiting lobby item by id.
     *
     * @param itemId Item id
     */
    void unregisterWaitingItem(String itemId);

    /**
     * Apply formatted display name and lore to an existing item.
     *
     * @param item        Base item stack
     * @param displayName Display name to apply (MiniMessage/legacy supported)
     * @param lore        Lore lines to apply (MiniMessage/legacy supported)
     * @return Decorated ItemStack instance
     */
    I decorate(I item, String displayName, List<String> lore);

    /**
     * Apply formatted display name and lore using player-aware placeholders.
     *
     * @param item         Base item stack
     * @param displayName  Display name to apply (MiniMessage/legacy supported)
     * @param lore         Lore lines to apply (MiniMessage/legacy supported)
     * @param player       Player context for placeholders (can be null)
     * @param placeholders Additional placeholders to inject before formatting
     * @return Decorated ItemStack instance
     */
    I decorate(I item,
                       String displayName,
                       List<String> lore,
                       P player,
                       Map<String, String> placeholders);

    /**
     * Format a display name using BlueArcade's color pipeline.
     *
     * @param displayName Raw display name
     * @return Formatted legacy string ready for ItemMeta#setDisplayName
     */
    String formatDisplayName(String displayName);

    /**
     * Format lore lines using BlueArcade's color pipeline.
     *
     * @param lore Raw lore lines
     * @return Formatted lore lines ready for ItemMeta#setLore
     */
    List<String> formatLore(List<String> lore);

    /**
     * Format an inventory title using BlueArcade's color pipeline.
     *
     * @param title Raw title
     * @return Formatted legacy title string for inventory creation
     */
    String formatInventoryTitle(String title);
}
