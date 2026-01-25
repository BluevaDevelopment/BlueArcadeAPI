package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Two-button modal dialog menu for Bedrock edition.
 * <p>
 * Modal menus present a yes/no or confirm/cancel choice to the player.
 * They display content text and two action buttons.
 * </p>
 *
 * @param title the modal dialog title
 * @param content the list of content/description lines
 * @param confirm the confirmation/yes button definition
 * @param cancel the cancellation/no button definition
 */
public record BedrockModalMenuDefinition(String title,
                                         List<String> content,
                                         BedrockButtonDefinition confirm,
                                         BedrockButtonDefinition cancel) implements BedrockMenuDefinition {
}
