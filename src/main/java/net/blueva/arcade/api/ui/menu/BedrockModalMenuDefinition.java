package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Two-button modal dialog menu for Bedrock edition.
 * <p>
 * Modal menus present a yes/no or confirm/cancel choice to the player.
 * They display content text and two action buttons.
 * </p>
 *
 * @param title the modal dialog title
 * @param content the list of content/description lines
 * @param confirm the confirmation/yes button definition
 * @param cancel the cancellation/no button definition
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCBedrockModalMenuDefinition} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class BedrockModalMenuDefinition implements BedrockMenuDefinition {

    private final String title;
    private final List<String> content;
    private final BedrockButtonDefinition confirm;
    private final BedrockButtonDefinition cancel;

    public BedrockModalMenuDefinition(String title, List<String> content, BedrockButtonDefinition confirm, BedrockButtonDefinition cancel) {
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

    public BedrockButtonDefinition confirm() {
        return this.confirm;
    }

    public BedrockButtonDefinition cancel() {
        return this.cancel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BedrockModalMenuDefinition)) {
            return false;
        }
        BedrockModalMenuDefinition other = (BedrockModalMenuDefinition) o;
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
        return "BedrockModalMenuDefinition[" +
            "title=" + this.title + ", " +
            "content=" + this.content + ", " +
            "confirm=" + this.confirm + ", " +
            "cancel=" + this.cancel +
            "]";
    }
}
