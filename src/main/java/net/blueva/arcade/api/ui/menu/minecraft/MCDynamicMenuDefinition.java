package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Dynamic (paginated) menu definition for Minecraft.
 *
 * @param <M> the material type (platform-specific)
 * @param javaTitle the inventory title for Java clients
 * @param javaSize the inventory size for Java clients (multiple of 9, max 54)
 * @param javaSlots the list of slots available for dynamic content in Java edition
 * @param staticItems the list of static items that remain fixed across all pages
 * @param bedrockMenu the menu definition for Bedrock clients
 * @since 3.2
 */
public record MCDynamicMenuDefinition<M>(String javaTitle,
                                         int javaSize,
                                         List<Integer> javaSlots,
                                         List<MCJavaMenuItem<M>> staticItems,
                                         MCBedrockSimpleMenuDefinition bedrockMenu) {
}
