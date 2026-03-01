package net.blueva.arcade.api.ui.menu;

/**
 * Dynamic menu entry with platform-specific render definitions.
 * <p>
 * MenuEntry allows defining a single logical menu item that can be rendered
 * differently on Java and Bedrock clients.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param javaItem the item definition for Java clients, or null
 * @param bedrockButton the button definition for Bedrock clients, or null
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCMenuEntry} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public record MenuEntry<M>(JavaItemDefinition<M> javaItem, BedrockButtonDefinition bedrockButton) {
    public static <M> MenuEntry<M> java(JavaItemDefinition<M> javaItem) {
        return new MenuEntry<>(javaItem, null);
    }

    public static <M> MenuEntry<M> bedrock(BedrockButtonDefinition bedrockButton) {
        return new MenuEntry<>(null, bedrockButton);
    }

    public static <M> MenuEntry<M> of(JavaItemDefinition<M> javaItem, BedrockButtonDefinition bedrockButton) {
        return new MenuEntry<>(javaItem, bedrockButton);
    }
}
