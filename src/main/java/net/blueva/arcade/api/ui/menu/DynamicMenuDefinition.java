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
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCDynamicMenuDefinition} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class DynamicMenuDefinition<M> {

    private final String javaTitle;
    private final int javaSize;
    private final List<Integer> javaSlots;
    private final List<JavaMenuItem<M>> staticItems;
    private final BedrockSimpleMenuDefinition bedrockMenu;

    public DynamicMenuDefinition(String javaTitle, int javaSize, List<Integer> javaSlots, List<JavaMenuItem<M>> staticItems, BedrockSimpleMenuDefinition bedrockMenu) {
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

    public List<JavaMenuItem<M>> staticItems() {
        return this.staticItems;
    }

    public BedrockSimpleMenuDefinition bedrockMenu() {
        return this.bedrockMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DynamicMenuDefinition)) {
            return false;
        }
        DynamicMenuDefinition<?> other = (DynamicMenuDefinition<?>) o;
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
        return "DynamicMenuDefinition[" +
            "javaTitle=" + this.javaTitle + ", " +
            "javaSize=" + this.javaSize + ", " +
            "javaSlots=" + this.javaSlots + ", " +
            "staticItems=" + this.staticItems + ", " +
            "bedrockMenu=" + this.bedrockMenu +
            "]";
    }
}
