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
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCMenuDefinition} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class MenuDefinition<M> {

    private final String javaTitle;
    private final int javaSize;
    private final List<JavaMenuItem<M>> javaItems;
    private final BedrockMenuDefinition bedrockMenu;

    public MenuDefinition(String javaTitle, int javaSize, List<JavaMenuItem<M>> javaItems, BedrockMenuDefinition bedrockMenu) {
        this.javaTitle = javaTitle;
        this.javaSize = javaSize;
        this.javaItems = javaItems;
        this.bedrockMenu = bedrockMenu;
    }

    public String javaTitle() {
        return this.javaTitle;
    }

    public int javaSize() {
        return this.javaSize;
    }

    public List<JavaMenuItem<M>> javaItems() {
        return this.javaItems;
    }

    public BedrockMenuDefinition bedrockMenu() {
        return this.bedrockMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuDefinition)) {
            return false;
        }
        MenuDefinition<?> other = (MenuDefinition<?>) o;
        return java.util.Objects.equals(this.javaTitle, other.javaTitle)
            && this.javaSize == other.javaSize
            && java.util.Objects.equals(this.javaItems, other.javaItems)
            && java.util.Objects.equals(this.bedrockMenu, other.bedrockMenu);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(javaTitle, javaSize, javaItems, bedrockMenu);
    }

    @Override
    public String toString() {
        return "MenuDefinition[" +
            "javaTitle=" + this.javaTitle + ", " +
            "javaSize=" + this.javaSize + ", " +
            "javaItems=" + this.javaItems + ", " +
            "bedrockMenu=" + this.bedrockMenu +
            "]";
    }
}
