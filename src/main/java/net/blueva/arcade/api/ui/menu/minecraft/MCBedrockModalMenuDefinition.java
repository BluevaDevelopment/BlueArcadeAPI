package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Two-button modal dialog for Minecraft Bedrock Edition (Floodgate).
 *
 * @param title the modal dialog title
 * @param content the list of content/description lines
 * @param confirm the confirmation button definition
 * @param cancel the cancellation button definition
 * @since 3.2
 */
public final class MCBedrockModalMenuDefinition implements MCBedrockMenuDefinition {

    private final String title;
    private final List<String> content;
    private final MCBedrockButtonDefinition confirm;
    private final MCBedrockButtonDefinition cancel;

    public MCBedrockModalMenuDefinition(String title, List<String> content, MCBedrockButtonDefinition confirm, MCBedrockButtonDefinition cancel) {
        this.title = title;
        this.content = content;
        this.confirm = confirm;
        this.cancel = cancel;
    }

    public String title() {
        return this.title;
    }

    public List<String> content() {
        return this.content;
    }

    public MCBedrockButtonDefinition confirm() {
        return this.confirm;
    }

    public MCBedrockButtonDefinition cancel() {
        return this.cancel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCBedrockModalMenuDefinition)) {
            return false;
        }
        MCBedrockModalMenuDefinition other = (MCBedrockModalMenuDefinition) o;
        return java.util.Objects.equals(this.title, other.title)
            && java.util.Objects.equals(this.content, other.content)
            && java.util.Objects.equals(this.confirm, other.confirm)
            && java.util.Objects.equals(this.cancel, other.cancel);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, content, confirm, cancel);
    }

    @Override
    public String toString() {
        return "MCBedrockModalMenuDefinition[" +
            "title=" + this.title + ", " +
            "content=" + this.content + ", " +
            "confirm=" + this.confirm + ", " +
            "cancel=" + this.cancel +
            "]";
    }
}
