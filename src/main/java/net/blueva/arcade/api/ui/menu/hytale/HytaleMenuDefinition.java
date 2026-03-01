package net.blueva.arcade.api.ui.menu.hytale;

import java.util.List;

/**
 * Static menu definition for Hytale's custom UI system.
 * <p>
 * Hytale menus are backed by {@code .ui} layout files that are downloaded
 * to the client when the player connects. The server manipulates the UI
 * by sending commands to set values and by receiving events for user
 * interactions.
 * </p>
 *
 * @param layoutPath the path to the {@code .ui} layout file relative to
 *                   {@code Common/UI/Custom/} (e.g. {@code "MyPlugin/Menu.ui"})
 * @param title the logical title of the menu (used for logging/identification)
 * @param elements the list of named UI elements whose values can be set from the server
 * @param eventBindings the list of event bindings that connect UI elements to server-side actions
 * @param dismissable whether the player can dismiss the UI without triggering an action
 * @since 3.2
 */
public record HytaleMenuDefinition(String layoutPath,
                                   String title,
                                   List<HytaleUIElement> elements,
                                   List<HytaleUIEventBinding> eventBindings,
                                   boolean dismissable) {

    /**
     * Creates a simple dismissable menu definition.
     *
     * @param layoutPath the layout file path
     * @param title the menu title
     * @param elements the settable UI elements
     * @param eventBindings the event bindings
     * @return a new dismissable HytaleMenuDefinition
     */
    public static HytaleMenuDefinition of(String layoutPath,
                                          String title,
                                          List<HytaleUIElement> elements,
                                          List<HytaleUIEventBinding> eventBindings) {
        return new HytaleMenuDefinition(layoutPath, title, elements, eventBindings, true);
    }
}
