package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Static menu definition for Minecraft (both Java and Bedrock editions).
 * <p>
 * Contains platform-specific menu configurations so that games can define
 * menus that render natively on both Java and Bedrock clients.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param javaTitle the title of the inventory menu for Java clients
 * @param javaSize the size of the inventory (must be multiple of 9, max 54)
 * @param javaItems the list of items to display in the Java inventory
 * @param bedrockMenu the menu definition for Bedrock clients
 * @since 3.2
 */
public record MCMenuDefinition<M>(String javaTitle,
                                  int javaSize,
                                  List<MCJavaMenuItem<M>> javaItems,
                                  MCBedrockMenuDefinition bedrockMenu) {
}
