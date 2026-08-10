package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Simple list-style menu for Minecraft Bedrock Edition (Floodgate).
 *
 * @param title the menu title
 * @param content the list of content/description lines
 * @param buttons the list of button options
 * @since 3.2
 */
public final class MCBedrockSimpleMenuDefinition implements MCBedrockMenuDefinition {

    private final String title;
    private final List<String> content;
    private final List<MCBedrockButtonDefinition> buttons;

    public MCBedrockSimpleMenuDefinition(String title, List<String> content, List<MCBedrockButtonDefinition> buttons) {
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

    public List<MCBedrockButtonDefinition> buttons() {
        return this.buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCBedrockSimpleMenuDefinition)) {
            return false;
        }
        MCBedrockSimpleMenuDefinition other = (MCBedrockSimpleMenuDefinition) o;
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
        return "MCBedrockSimpleMenuDefinition[" +
            "title=" + this.title + ", " +
            "content=" + this.content + ", " +
            "buttons=" + this.buttons +
            "]";
    }
}
