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
public final class MenuEntry<M> {

    private final JavaItemDefinition<M> javaItem;
    private final BedrockButtonDefinition bedrockButton;

    public MenuEntry(JavaItemDefinition<M> javaItem, BedrockButtonDefinition bedrockButton) {
        this.javaItem = javaItem;
        this.bedrockButton = bedrockButton;
    }

    public JavaItemDefinition<M> javaItem() {
        return this.javaItem;
    }

    public BedrockButtonDefinition bedrockButton() {
        return this.bedrockButton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuEntry)) {
            return false;
        }
        MenuEntry<?> other = (MenuEntry<?>) o;
        return java.util.Objects.equals(this.javaItem, other.javaItem)
            && java.util.Objects.equals(this.bedrockButton, other.bedrockButton);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(javaItem, bedrockButton);
    }

    @Override
    public String toString() {
        return "MenuEntry[" +
            "javaItem=" + this.javaItem + ", " +
            "bedrockButton=" + this.bedrockButton +
            "]";
    }

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
