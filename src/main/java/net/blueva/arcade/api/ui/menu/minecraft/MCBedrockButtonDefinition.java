package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Bedrock menu button definition for Minecraft (Floodgate) form-based UIs.
 *
 * @param text the button text displayed to players
 * @param imageUrl the URL to an image icon (optional), or null
 * @param actions the list of action commands to execute when clicked
 * @since 3.2
 */
public final class MCBedrockButtonDefinition {

    private final String text;
    private final String imageUrl;
    private final List<String> actions;

    public MCBedrockButtonDefinition(String text, String imageUrl, List<String> actions) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.actions = actions;
    }

    public String text() {
        return this.text;
    }

    public String imageUrl() {
        return this.imageUrl;
    }

    public List<String> actions() {
        return this.actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCBedrockButtonDefinition)) {
            return false;
        }
        MCBedrockButtonDefinition other = (MCBedrockButtonDefinition) o;
        return java.util.Objects.equals(this.text, other.text)
            && java.util.Objects.equals(this.imageUrl, other.imageUrl)
            && java.util.Objects.equals(this.actions, other.actions);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(text, imageUrl, actions);
    }

    @Override
    public String toString() {
        return "MCBedrockButtonDefinition[" +
            "text=" + this.text + ", " +
            "imageUrl=" + this.imageUrl + ", " +
            "actions=" + this.actions +
            "]";
    }

    public static MCBedrockButtonDefinition of(String text, List<String> actions) {
        return new MCBedrockButtonDefinition(text, null, actions);
    }

    public static MCBedrockButtonDefinition of(String text, String imageUrl, List<String> actions) {
        return new MCBedrockButtonDefinition(text, imageUrl, actions);
    }
}
