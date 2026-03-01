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
public record HytaleButtonDefinition(String selector,
                                     String text,
                                     String imageAsset,
                                     List<String> actions) {

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
