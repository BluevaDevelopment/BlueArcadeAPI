package net.blueva.arcade.api.ui;

import net.blueva.arcade.api.ui.menu.hytale.HytaleMenuDefinition;

import java.util.Collections;
import java.util.Map;

/**
 * Experimental API for opening and managing Hytale custom UI menus.
 * <p>
 * This API is Hytale-specific and is backed by HyUI pages in the core.
 * It is additive and optional: non-Hytale runtimes may return {@code null}
 * from accessors that expose this API.
 * </p>
 *
 * @param <P> player type
 * @since 3.2
 */
public interface HytaleMenuAPI<P> {

    /**
     * Register a reusable menu definition by id.
     *
     * @param menuId unique identifier (without extension)
     * @param definition menu definition
     */
    void registerMenu(String menuId, HytaleMenuDefinition definition);

    /**
     * Unregister a previously registered menu definition.
     *
     * @param menuId menu identifier
     */
    void unregisterMenu(String menuId);

    /**
     * Open a registered menu for the given player.
     *
     * @param player player to open for
     * @param menuId registered menu id
     * @return true if opened
     */
    default boolean openMenu(P player, String menuId) {
        return openMenu(player, menuId, Collections.emptyMap());
    }

    /**
     * Open a registered menu for the given player.
     *
     * @param player player to open for
     * @param menuId registered menu id
     * @param placeholders placeholder map
     * @return true if opened
     */
    boolean openMenu(P player, String menuId, Map<String, String> placeholders);

    /**
     * Open an ad-hoc menu definition for the given player.
     *
     * @param player player to open for
     * @param definition menu definition
     * @return true if opened
     */
    default boolean openMenu(P player, HytaleMenuDefinition definition) {
        return openMenu(player, definition, Collections.emptyMap());
    }

    /**
     * Open an ad-hoc menu definition for the given player.
     *
     * @param player player to open for
     * @param definition menu definition
     * @param placeholders placeholder map
     * @return true if opened
     */
    boolean openMenu(P player, HytaleMenuDefinition definition, Map<String, String> placeholders);

    /**
     * Register a module action handler for {@code MODULE;} menu actions.
     *
     * @param moduleId module id
     * @param handler action handler
     */
    void registerModuleActionHandler(String moduleId, HytaleMenuActionHandler<P> handler);

    /**
     * Unregister a previously registered module action handler.
     *
     * @param moduleId module id
     */
    void unregisterModuleActionHandler(String moduleId);
}
