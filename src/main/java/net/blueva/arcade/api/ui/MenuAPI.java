package net.blueva.arcade.api.ui;

import net.blueva.arcade.api.ui.menu.DynamicMenuDefinition;
import net.blueva.arcade.api.ui.menu.MenuDefinition;
import net.blueva.arcade.api.ui.menu.MenuEntry;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * API for opening custom menus in a platform-agnostic way.
 */
public interface MenuAPI<P, M> {

    /**
     * Open a static menu for a player.
     *
     * @param player Player that will receive the menu
     * @param menu   Menu definition
     * @return true if the menu was opened
     */
    default boolean openMenu(P player, MenuDefinition<M> menu) {
        return openMenu(player, menu, Collections.emptyMap());
    }

    /**
     * Open a static menu for a player with placeholder replacements.
     *
     * @param player       Player that will receive the menu
     * @param menu         Menu definition
     * @param placeholders Placeholder values (e.g. "{player}")
     * @return true if the menu was opened
     */
    boolean openMenu(P player, MenuDefinition<M> menu, Map<String, String> placeholders);

    /**
     * Open a dynamic menu for a player.
     *
     * @param player Player that will receive the menu
     * @param menu   Dynamic menu definition
     * @param entries Entries to render
     * @param page   Page index starting at 1
     * @return true if the menu was opened
     */
    default boolean openDynamicMenu(P player, DynamicMenuDefinition<M> menu, List<MenuEntry<M>> entries, int page) {
        return openDynamicMenu(player, menu, entries, page, Collections.emptyMap());
    }

    /**
     * Open a dynamic menu for a player with placeholder replacements.
     *
     * @param player       Player that will receive the menu
     * @param menu         Dynamic menu definition
     * @param entries      Entries to render
     * @param page         Page index starting at 1
     * @param placeholders Placeholder values (e.g. "{player}")
     * @return true if the menu was opened
     */
    boolean openDynamicMenu(P player, DynamicMenuDefinition<M> menu, List<MenuEntry<M>> entries, int page,
                            Map<String, String> placeholders);

    /**
     * Check if a player is a Bedrock player (Floodgate).
     *
     * @param player Player instance
     * @return true if the player is Bedrock
     */
    boolean isBedrockPlayer(P player);

    /**
     * Register a module action handler for menu actions.
     *
     * @param moduleId Module identifier (e.g., "skywars")
     * @param handler  Handler to execute for MODULE actions
     */
    void registerModuleActionHandler(String moduleId, ModuleActionHandler<P> handler);

    /**
     * Unregister a module action handler.
     *
     * @param moduleId Module identifier
     */
    void unregisterModuleActionHandler(String moduleId);

    /**
     * Open a menu by ID. The menu must be registered with the core MenuManager.
     *
     * @param player Player to open the menu for
     * @param menuId Menu identifier (without .yml extension)
     * @return true if the menu was opened successfully
     */
    boolean openMenuById(P player, String menuId);
}
