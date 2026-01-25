package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Bedrock menu button definition for form-based UIs.
 * <p>
 * Defines a clickable button in a Bedrock form menu, including display text,
 * optional image, and actions to execute when clicked.
 * </p>
 *
 * @param text the button text displayed to players
 * @param imageUrl the URL to an image icon (optional), or null
 * @param actions the list of action commands to execute when clicked
 */
public record BedrockButtonDefinition(String text, String imageUrl, List<String> actions) {

    /**
     * Creates a button without an image.
     *
     * @param text the button text
     * @param actions the actions to execute
     * @return a new BedrockButtonDefinition
     */
    public static BedrockButtonDefinition of(String text, List<String> actions) {
        return new BedrockButtonDefinition(text, null, actions);
    }

    /**
     * Creates a button with an image.
     *
     * @param text the button text
     * @param imageUrl the image URL
     * @param actions the actions to execute
     * @return a new BedrockButtonDefinition
     */
    public static BedrockButtonDefinition of(String text, String imageUrl, List<String> actions) {
        return new BedrockButtonDefinition(text, imageUrl, actions);
    }
}
