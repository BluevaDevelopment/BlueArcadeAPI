package net.blueva.arcade.api.ui.menu.minecraft;

/**
 * Dynamic menu entry for Minecraft with Java and Bedrock render definitions.
 *
 * @param <M> the material type (platform-specific)
 * @param javaItem the item definition for Java clients, or null
 * @param bedrockButton the button definition for Bedrock clients, or null
 * @since 3.2
 */
public record MCMenuEntry<M>(MCJavaItemDefinition<M> javaItem, MCBedrockButtonDefinition bedrockButton) {

    public static <M> MCMenuEntry<M> java(MCJavaItemDefinition<M> javaItem) {
        return new MCMenuEntry<>(javaItem, null);
    }

    public static <M> MCMenuEntry<M> bedrock(MCBedrockButtonDefinition bedrockButton) {
        return new MCMenuEntry<>(null, bedrockButton);
    }

    public static <M> MCMenuEntry<M> of(MCJavaItemDefinition<M> javaItem, MCBedrockButtonDefinition bedrockButton) {
        return new MCMenuEntry<>(javaItem, bedrockButton);
    }
}
