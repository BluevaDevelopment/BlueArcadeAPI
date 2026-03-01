package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Bedrock menu button definition for Minecraft (Floodgate) form-based UIs.
 *
 * @param text the button text displayed to players
 * @param imageUrl the URL to an image icon (optional), or null
 * @param actions the list of action commands to execute when clicked
 * @since 3.2
 */
public record MCBedrockButtonDefinition(String text, String imageUrl, List<String> actions) {

    public static MCBedrockButtonDefinition of(String text, List<String> actions) {
        return new MCBedrockButtonDefinition(text, null, actions);
    }

    public static MCBedrockButtonDefinition of(String text, String imageUrl, List<String> actions) {
        return new MCBedrockButtonDefinition(text, imageUrl, actions);
    }
}
