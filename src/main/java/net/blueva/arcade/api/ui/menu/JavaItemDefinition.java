package net.blueva.arcade.api.ui.menu;

import java.util.List;

/**
 * Item definition for Java edition inventory menus.
 * <p>
 * Defines the appearance and behavior of an item in a Java inventory menu,
 * including material, display name, lore, and click actions.
 * </p>
 *
 * @param <M> the material type (platform-specific)
 * @param material the material/item type to display
 * @param amount the stack size (1-64)
 * @param name the colored display name
 * @param lore the list of lore lines
 * @param skullValue the base64 skull texture value (for player heads), or null
 * @param actions the list of action commands to execute when clicked
 */
public record JavaItemDefinition<M>(M material,
                                    int amount,
                                    String name,
                                    List<String> lore,
                                    String skullValue,
                                    List<String> actions) {

    public static <M> JavaItemDefinition<M> of(M material, String name, List<String> lore, List<String> actions) {
        return new JavaItemDefinition<>(material, 1, name, lore, null, actions);
    }

    public static <M> JavaItemDefinition<M> of(M material, int amount, String name, List<String> lore,
                                               List<String> actions) {
        return new JavaItemDefinition<>(material, amount, name, lore, null, actions);
    }

    public static <M> JavaItemDefinition<M> skull(M skullMaterial, String skullValue, String name,
                                                  List<String> lore, List<String> actions) {
        return new JavaItemDefinition<>(skullMaterial, 1, name, lore, skullValue, actions);
    }
}
