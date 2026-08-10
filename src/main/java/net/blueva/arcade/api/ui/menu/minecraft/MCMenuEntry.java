package net.blueva.arcade.api.ui.menu.minecraft;

/**
 * Dynamic menu entry for Minecraft with Java and Bedrock render definitions.
 *
 * @param <M> the material type (platform-specific)
 * @param javaItem the item definition for Java clients, or null
 * @param bedrockButton the button definition for Bedrock clients, or null
 * @since 3.2
 */
public final class MCMenuEntry<M> {

    private final MCJavaItemDefinition<M> javaItem;
    private final MCBedrockButtonDefinition bedrockButton;

    public MCMenuEntry(MCJavaItemDefinition<M> javaItem, MCBedrockButtonDefinition bedrockButton) {
        this.javaItem = javaItem;
        this.bedrockButton = bedrockButton;
    }

    public MCJavaItemDefinition<M> javaItem() {
        return this.javaItem;
    }

    public MCBedrockButtonDefinition bedrockButton() {
        return this.bedrockButton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCMenuEntry)) {
            return false;
        }
        MCMenuEntry<?> other = (MCMenuEntry<?>) o;
        return java.util.Objects.equals(this.javaItem, other.javaItem)
            && java.util.Objects.equals(this.bedrockButton, other.bedrockButton);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(javaItem, bedrockButton);
    }

    @Override
    public String toString() {
        return "MCMenuEntry[" +
            "javaItem=" + this.javaItem + ", " +
            "bedrockButton=" + this.bedrockButton +
            "]";
    }

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
