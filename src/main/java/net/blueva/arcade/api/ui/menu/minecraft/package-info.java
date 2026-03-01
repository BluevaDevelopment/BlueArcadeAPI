/**
 * Minecraft-specific menu definitions.
 * <p>
 * This package contains menu types designed for the Minecraft platform:
 * <ul>
 *   <li><b>Java Edition</b> – inventory-based GUIs with {@link MCJavaItemDefinition}
 *       and {@link MCJavaMenuItem}.</li>
 *   <li><b>Bedrock Edition</b> – form-based UIs via Floodgate with
 *       {@link MCBedrockMenuDefinition}, {@link MCBedrockSimpleMenuDefinition},
 *       {@link MCBedrockModalMenuDefinition}, and {@link MCBedrockButtonDefinition}.</li>
 * </ul>
 * Use {@link MCMenuDefinition} and {@link MCDynamicMenuDefinition} to build
 * menus that render natively on both Java and Bedrock clients.
 *
 * @since 3.2
 */
package net.blueva.arcade.api.ui.menu.minecraft;
