package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Bedrock menu button definition for form-based UIs.
 * <p>
 * Defines a clickable button in a Bedrock form menu, including display text,
 * optional image, and actions to execute when clicked.
 * </p>
 *
 * @param text the button text displayed to players
 * @param imageUrl the URL to an image icon (optional), or null
 * @param actions the list of action commands to execute when clicked
 * @deprecated Since 3.2. Use
 *   {@link net.blueva.arcade.api.ui.menu.minecraft.MCBedrockButtonDefinition} instead.
 *   This class is kept for backward compatibility with API 3.1 modules.
 */
@Deprecated
public final class BedrockButtonDefinition {

    private final String text;
    private final String imageUrl;
    private final List<String> actions;

    public BedrockButtonDefinition(String text, String imageUrl, List<String> actions) {
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
        if (!(o instanceof BedrockButtonDefinition)) {
            return false;
        }
        BedrockButtonDefinition other = (BedrockButtonDefinition) o;
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
        return "BedrockButtonDefinition[" +
            "text=" + this.text + ", " +
            "imageUrl=" + this.imageUrl + ", " +
            "actions=" + this.actions +
            "]";
    }

    /**
     * Creates a button without an image.
     *
     * @param text the button text
     * @param actions the actions to execute
     * @return a new BedrockButtonDefinition
     */
    public static BedrockButtonDefinition of(String text, List<String> actions) {
        return new BedrockButtonDefinition(text, null, actions);
    }

    /**
     * Creates a button with an image.
     *
     * @param text the button text
     * @param imageUrl the image URL
     * @param actions the actions to execute
     * @return a new BedrockButtonDefinition
     */
    public static BedrockButtonDefinition of(String text, String imageUrl, List<String> actions) {
        return new BedrockButtonDefinition(text, imageUrl, actions);
    }
}
