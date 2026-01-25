package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Simple list-style menu for Bedrock edition.
 * <p>
 * Simple menus display a list of buttons that players can click.
 * Each button can have text, an image, and associated actions.
 * </p>
 *
 * @param title the menu title
 * @param content the list of content/description lines
 * @param buttons the list of button options available to the player
 */
public record BedrockSimpleMenuDefinition(String title,
                                          List<String> content,
                                          List<BedrockButtonDefinition> buttons) implements BedrockMenuDefinition {
}
