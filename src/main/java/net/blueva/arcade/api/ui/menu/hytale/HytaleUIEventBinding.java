package net.blueva.arcade.api.ui.menu.hytale;

import java.util.List;

/**
 * Binds a Hytale UI element to a server-side action.
 * <p>
 * When the user interacts with the element in the client UI, the server
 * receives an event with the specified action identifier. The event type
 * corresponds to Hytale's {@code CustomUIEventBindingType} values.
 * </p>
 *
 * @param elementSelector the CSS-like selector for the target element
 *                        (e.g. {@code "#ConfirmButton"})
 * @param eventType the Hytale UI event type name (e.g.
 *                  {@code "Activating"}, {@code "Hovering"})
 * @param actionId an action identifier sent back to the server handler
 * @param actions the list of action commands to execute when triggered
 * @since 3.2
 */
public record HytaleUIEventBinding(String elementSelector,
                                   String eventType,
                                   String actionId,
                                   List<String> actions) {

    /**
     * Creates a simple button-click binding.
     *
     * @param selector the element selector
     * @param actionId the action identifier
     * @param actions the actions to execute
     * @return a new HytaleUIEventBinding for Activating events
     */
    public static HytaleUIEventBinding click(String selector, String actionId, List<String> actions) {
        return new HytaleUIEventBinding(selector, "Activating", actionId, actions);
    }
}
