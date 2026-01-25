package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Dynamic menu definition with page-based entry rendering.
 * <p>
 * Dynamic menus support pagination, displaying dynamic content in specific slots
 * while maintaining static items (like navigation buttons) in fixed positions.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param javaTitle the inventory title for Java clients
 * @param javaSize the inventory size for Java clients (multiple of 9, max 54)
 * @param javaSlots the list of slots available for dynamic content in Java edition
 * @param staticItems the list of static items that remain fixed across all pages
 * @param bedrockMenu the menu definition for Bedrock clients
 */
public record DynamicMenuDefinition<M>(String javaTitle,
                                       int javaSize,
                                       List<Integer> javaSlots,
                                       List<JavaMenuItem<M>> staticItems,
                                       BedrockSimpleMenuDefinition bedrockMenu) {
}
