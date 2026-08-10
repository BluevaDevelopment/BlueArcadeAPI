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
public final class HytaleUIEventBinding {

    private final String elementSelector;
    private final String eventType;
    private final String actionId;
    private final List<String> actions;

    public HytaleUIEventBinding(String elementSelector, String eventType, String actionId, List<String> actions) {
        this.elementSelector = elementSelector;
        this.eventType = eventType;
        this.actionId = actionId;
        this.actions = actions;
    }

    public String elementSelector() {
        return this.elementSelector;
    }

    public String eventType() {
        return this.eventType;
    }

    public String actionId() {
        return this.actionId;
    }

    public List<String> actions() {
        return this.actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HytaleUIEventBinding)) {
            return false;
        }
        HytaleUIEventBinding other = (HytaleUIEventBinding) o;
        return java.util.Objects.equals(this.elementSelector, other.elementSelector)
            && java.util.Objects.equals(this.eventType, other.eventType)
            && java.util.Objects.equals(this.actionId, other.actionId)
            && java.util.Objects.equals(this.actions, other.actions);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(elementSelector, eventType, actionId, actions);
    }

    @Override
    public String toString() {
        return "HytaleUIEventBinding[" +
            "elementSelector=" + this.elementSelector + ", " +
            "eventType=" + this.eventType + ", " +
            "actionId=" + this.actionId + ", " +
            "actions=" + this.actions +
            "]";
    }

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
