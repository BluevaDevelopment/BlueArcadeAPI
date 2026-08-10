package net.blueva.arcade.api.ui.menu.hytale;

import java.util.List;

/**
 * Defines a clickable button in a Hytale custom UI page.
 * <p>
 * Hytale buttons are elements in a {@code .ui} layout that the player can
 * activate. They are referenced by their selector and bound to server-side
 * actions via {@link HytaleUIEventBinding}.
 * </p>
 *
 * @param selector the element selector in the layout (e.g. {@code "#PlayButton"})
 * @param text the display text of the button
 * @param imageAsset optional path to a texture asset relative to the
 *                   plugin resource pack, or {@code null}
 * @param actions the list of action commands to execute when clicked
 * @since 3.2
 */
public final class HytaleButtonDefinition {

    private final String selector;
    private final String text;
    private final String imageAsset;
    private final List<String> actions;

    public HytaleButtonDefinition(String selector, String text, String imageAsset, List<String> actions) {
        this.selector = selector;
        this.text = text;
        this.imageAsset = imageAsset;
        this.actions = actions;
    }

    public String selector() {
        return this.selector;
    }

    public String text() {
        return this.text;
    }

    public String imageAsset() {
        return this.imageAsset;
    }

    public List<String> actions() {
        return this.actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HytaleButtonDefinition)) {
            return false;
        }
        HytaleButtonDefinition other = (HytaleButtonDefinition) o;
        return java.util.Objects.equals(this.selector, other.selector)
            && java.util.Objects.equals(this.text, other.text)
            && java.util.Objects.equals(this.imageAsset, other.imageAsset)
            && java.util.Objects.equals(this.actions, other.actions);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(selector, text, imageAsset, actions);
    }

    @Override
    public String toString() {
        return "HytaleButtonDefinition[" +
            "selector=" + this.selector + ", " +
            "text=" + this.text + ", " +
            "imageAsset=" + this.imageAsset + ", " +
            "actions=" + this.actions +
            "]";
    }

    /**
     * Creates a button without an image.
     *
     * @param selector the element selector
     * @param text the button text
     * @param actions the actions to execute
     * @return a new HytaleButtonDefinition
     */
    public static HytaleButtonDefinition of(String selector, String text, List<String> actions) {
        return new HytaleButtonDefinition(selector, text, null, actions);
    }

    /**
     * Creates a button with an image asset.
     *
     * @param selector the element selector
     * @param text the button text
     * @param imageAsset the image asset path
     * @param actions the actions to execute
     * @return a new HytaleButtonDefinition
     */
    public static HytaleButtonDefinition of(String selector, String text, String imageAsset, List<String> actions) {
        return new HytaleButtonDefinition(selector, text, imageAsset, actions);
    }
}
