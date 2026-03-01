package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Two-button modal dialog for Minecraft Bedrock Edition (Floodgate).
 *
 * @param title the modal dialog title
 * @param content the list of content/description lines
 * @param confirm the confirmation button definition
 * @param cancel the cancellation button definition
 * @since 3.2
 */
public record MCBedrockModalMenuDefinition(String title,
                                           List<String> content,
                                           MCBedrockButtonDefinition confirm,
                                           MCBedrockButtonDefinition cancel) implements MCBedrockMenuDefinition {
}
