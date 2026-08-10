package net.blueva.arcade.api.ui.menu.hytale;

/**
 * Represents a named element in a Hytale {@code .ui} layout whose value
 * can be set from the server side.
 * <p>
 * Element selectors follow Hytale's UI DSL: identifiers prefixed with
 * {@code #} target elements by ID, while other strings may target by type.
 * </p>
 *
 * @param selector the element selector in the layout (e.g. {@code "#TitleLabel"})
 * @param property the property to set (e.g. {@code "Text"}, {@code "Visible"})
 * @param defaultValue the default value to set when the menu opens, or {@code null}
 * @since 3.2
 */
public final class HytaleUIElement {

    private final String selector;
    private final String property;
    private final String defaultValue;

    public HytaleUIElement(String selector, String property, String defaultValue) {
        this.selector = selector;
        this.property = property;
        this.defaultValue = defaultValue;
    }

    public String selector() {
        return this.selector;
    }

    public String property() {
        return this.property;
    }

    public String defaultValue() {
        return this.defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HytaleUIElement)) {
            return false;
        }
        HytaleUIElement other = (HytaleUIElement) o;
        return java.util.Objects.equals(this.selector, other.selector)
            && java.util.Objects.equals(this.property, other.property)
            && java.util.Objects.equals(this.defaultValue, other.defaultValue);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(selector, property, defaultValue);
    }

    @Override
    public String toString() {
        return "HytaleUIElement[" +
            "selector=" + this.selector + ", " +
            "property=" + this.property + ", " +
            "defaultValue=" + this.defaultValue +
            "]";
    }

    /**
     * Creates a text element with a default value.
     *
     * @param selector the element selector
     * @param defaultValue the default text
     * @return a new HytaleUIElement for the Text property
     */
    public static HytaleUIElement text(String selector, String defaultValue) {
        return new HytaleUIElement(selector, "Text", defaultValue);
    }

    /**
     * Creates a visibility element.
     *
     * @param selector the element selector
     * @param visible whether the element should be visible by default
     * @return a new HytaleUIElement for the Visible property
     */
    public static HytaleUIElement visibility(String selector, boolean visible) {
        return new HytaleUIElement(selector, "Visible", String.valueOf(visible));
    }
}
