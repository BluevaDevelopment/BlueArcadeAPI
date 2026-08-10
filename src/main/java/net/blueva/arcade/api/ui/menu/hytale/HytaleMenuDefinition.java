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
public final class HytaleMenuDefinition {

    private final String layoutPath;
    private final String title;
    private final List<HytaleUIElement> elements;
    private final List<HytaleUIEventBinding> eventBindings;
    private final boolean dismissable;

    public HytaleMenuDefinition(String layoutPath, String title, List<HytaleUIElement> elements, List<HytaleUIEventBinding> eventBindings, boolean dismissable) {
        this.layoutPath = layoutPath;
        this.title = title;
        this.elements = elements;
        this.eventBindings = eventBindings;
        this.dismissable = dismissable;
    }

    public String layoutPath() {
        return this.layoutPath;
    }

    public String title() {
        return this.title;
    }

    public List<HytaleUIElement> elements() {
        return this.elements;
    }

    public List<HytaleUIEventBinding> eventBindings() {
        return this.eventBindings;
    }

    public boolean dismissable() {
        return this.dismissable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HytaleMenuDefinition)) {
            return false;
        }
        HytaleMenuDefinition other = (HytaleMenuDefinition) o;
        return java.util.Objects.equals(this.layoutPath, other.layoutPath)
            && java.util.Objects.equals(this.title, other.title)
            && java.util.Objects.equals(this.elements, other.elements)
            && java.util.Objects.equals(this.eventBindings, other.eventBindings)
            && this.dismissable == other.dismissable;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(layoutPath, title, elements, eventBindings, dismissable);
    }

    @Override
    public String toString() {
        return "HytaleMenuDefinition[" +
            "layoutPath=" + this.layoutPath + ", " +
            "title=" + this.title + ", " +
            "elements=" + this.elements + ", " +
            "eventBindings=" + this.eventBindings + ", " +
            "dismissable=" + this.dismissable +
            "]";
    }

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
