package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Simple list-style menu for Minecraft Bedrock Edition (Floodgate).
 *
 * @param title the menu title
 * @param content the list of content/description lines
 * @param buttons the list of button options
 * @since 3.2
 */
public record MCBedrockSimpleMenuDefinition(String title,
                                            List<String> content,
                                            List<MCBedrockButtonDefinition> buttons) implements MCBedrockMenuDefinition {
}
