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
public final class MCDynamicMenuDefinition<M> {

    private final String javaTitle;
    private final int javaSize;
    private final List<Integer> javaSlots;
    private final List<MCJavaMenuItem<M>> staticItems;
    private final MCBedrockSimpleMenuDefinition bedrockMenu;

    public MCDynamicMenuDefinition(String javaTitle, int javaSize, List<Integer> javaSlots, List<MCJavaMenuItem<M>> staticItems, MCBedrockSimpleMenuDefinition bedrockMenu) {
        this.javaTitle = javaTitle;
        this.javaSize = javaSize;
        this.javaSlots = javaSlots;
        this.staticItems = staticItems;
        this.bedrockMenu = bedrockMenu;
    }

    public String javaTitle() {
        return this.javaTitle;
    }

    public int javaSize() {
        return this.javaSize;
    }

    public List<Integer> javaSlots() {
        return this.javaSlots;
    }

    public List<MCJavaMenuItem<M>> staticItems() {
        return this.staticItems;
    }

    public MCBedrockSimpleMenuDefinition bedrockMenu() {
        return this.bedrockMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCDynamicMenuDefinition)) {
            return false;
        }
        MCDynamicMenuDefinition<?> other = (MCDynamicMenuDefinition<?>) o;
        return java.util.Objects.equals(this.javaTitle, other.javaTitle)
            && this.javaSize == other.javaSize
            && java.util.Objects.equals(this.javaSlots, other.javaSlots)
            && java.util.Objects.equals(this.staticItems, other.staticItems)
            && java.util.Objects.equals(this.bedrockMenu, other.bedrockMenu);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(javaTitle, javaSize, javaSlots, staticItems, bedrockMenu);
    }

    @Override
    public String toString() {
        return "MCDynamicMenuDefinition[" +
            "javaTitle=" + this.javaTitle + ", " +
            "javaSize=" + this.javaSize + ", " +
            "javaSlots=" + this.javaSlots + ", " +
            "staticItems=" + this.staticItems + ", " +
            "bedrockMenu=" + this.bedrockMenu +
            "]";
    }
}
