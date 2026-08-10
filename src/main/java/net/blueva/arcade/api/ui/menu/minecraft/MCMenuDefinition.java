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
public final class MCMenuDefinition<M> {

    private final String javaTitle;
    private final int javaSize;
    private final List<MCJavaMenuItem<M>> javaItems;
    private final MCBedrockMenuDefinition bedrockMenu;

    public MCMenuDefinition(String javaTitle, int javaSize, List<MCJavaMenuItem<M>> javaItems, MCBedrockMenuDefinition bedrockMenu) {
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

    public List<MCJavaMenuItem<M>> javaItems() {
        return this.javaItems;
    }

    public MCBedrockMenuDefinition bedrockMenu() {
        return this.bedrockMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCMenuDefinition)) {
            return false;
        }
        MCMenuDefinition<?> other = (MCMenuDefinition<?>) o;
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
        return "MCMenuDefinition[" +
            "javaTitle=" + this.javaTitle + ", " +
            "javaSize=" + this.javaSize + ", " +
            "javaItems=" + this.javaItems + ", " +
            "bedrockMenu=" + this.bedrockMenu +
            "]";
    }
}
