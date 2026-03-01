package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Base definition for Bedrock edition menus.
 * <p>
 * Bedrock menus use forms instead of inventory screens. This sealed interface
 * is implemented by modal and simple menu types.
 * </p>
 *
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCBedrockMenuDefinition} instead.
 *   This interface is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
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
