package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Simple list-style menu for Bedrock edition.
 * <p>
 * Simple menus display a list of buttons that players can click.
 * Each button can have text, an image, and associated actions.
 * </p>
 *
 * @param title the menu title
 * @param content the list of content/description lines
 * @param buttons the list of button options available to the player
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCBedrockSimpleMenuDefinition} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class BedrockSimpleMenuDefinition implements BedrockMenuDefinition {

    private final String title;
    private final List<String> content;
    private final List<BedrockButtonDefinition> buttons;

    public BedrockSimpleMenuDefinition(String title, List<String> content, List<BedrockButtonDefinition> buttons) {
        this.title = title;
        this.content = content;
        this.buttons = buttons;
    }

    public String title() {
        return this.title;
    }

    public List<String> content() {
        return this.content;
    }

    public List<BedrockButtonDefinition> buttons() {
        return this.buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BedrockSimpleMenuDefinition)) {
            return false;
        }
        BedrockSimpleMenuDefinition other = (BedrockSimpleMenuDefinition) o;
        return java.util.Objects.equals(this.title, other.title)
            && java.util.Objects.equals(this.content, other.content)
            && java.util.Objects.equals(this.buttons, other.buttons);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, content, buttons);
    }

    @Override
    public String toString() {
        return "BedrockSimpleMenuDefinition[" +
            "title=" + this.title + ", " +
            "content=" + this.content + ", " +
            "buttons=" + this.buttons +
            "]";
    }
}
