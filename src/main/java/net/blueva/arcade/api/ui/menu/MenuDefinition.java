package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Static menu definition for both Java and Bedrock editions.
 * <p>
 * This record contains platform-specific menu configurations, allowing games
 * to define menus that work on both Java and Bedrock clients simultaneously.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param javaTitle the title of the inventory menu for Java clients
 * @param javaSize the size of the inventory (must be multiple of 9, max 54)
 * @param javaItems the list of items to display in the Java inventory
 * @param bedrockMenu the menu definition for Bedrock clients
 */
public record MenuDefinition<M>(String javaTitle,
                                int javaSize,
                                List<JavaMenuItem<M>> javaItems,
                                BedrockMenuDefinition bedrockMenu) {
}
