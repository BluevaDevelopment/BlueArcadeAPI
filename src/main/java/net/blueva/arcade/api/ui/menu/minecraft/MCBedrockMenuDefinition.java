package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Base definition for Minecraft Bedrock Edition menus.
 * <p>
 * Bedrock menus use Floodgate forms instead of inventory screens.
 * This sealed interface is implemented by modal and simple menu types.
 * </p>
 *
 * @since 3.2
 */
public sealed interface MCBedrockMenuDefinition
        permits MCBedrockModalMenuDefinition, MCBedrockSimpleMenuDefinition {

    /** Gets the menu title. */
    String title();

    /** Gets the menu content lines. */
    List<String> content();
}
