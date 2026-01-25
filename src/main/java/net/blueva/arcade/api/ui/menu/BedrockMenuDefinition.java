package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Base definition for Bedrock edition menus.
 * <p>
 * Bedrock menus use forms instead of inventory screens. This sealed interface
 * is implemented by modal and simple menu types.
 * </p>
 */
public sealed interface BedrockMenuDefinition permits BedrockModalMenuDefinition, BedrockSimpleMenuDefinition {
    /**
     * Gets the menu title.
     *
     * @return the menu title
     */
    String title();

    /**
     * Gets the menu content lines.
     *
     * @return the list of content/description lines
     */
    List<String> content();
}
