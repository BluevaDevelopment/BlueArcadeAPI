package net.blueva.arcade.api.ui.menu.minecraft;

import java.util.List;

/**
 * Item definition for Minecraft Java Edition inventory menus.
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
 * @since 3.2
 */
public final class MCJavaItemDefinition<M> {

    private final M material;
    private final int amount;
    private final String name;
    private final List<String> lore;
    private final String skullValue;
    private final List<String> actions;

    public MCJavaItemDefinition(M material, int amount, String name, List<String> lore, String skullValue, List<String> actions) {
        this.material = material;
        this.amount = amount;
        this.name = name;
        this.lore = lore;
        this.skullValue = skullValue;
        this.actions = actions;
    }

    public M material() {
        return this.material;
    }

    public int amount() {
        return this.amount;
    }

    public String name() {
        return this.name;
    }

    public List<String> lore() {
        return this.lore;
    }

    public String skullValue() {
        return this.skullValue;
    }

    public List<String> actions() {
        return this.actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MCJavaItemDefinition)) {
            return false;
        }
        MCJavaItemDefinition<?> other = (MCJavaItemDefinition<?>) o;
        return java.util.Objects.equals(this.material, other.material)
            && this.amount == other.amount
            && java.util.Objects.equals(this.name, other.name)
            && java.util.Objects.equals(this.lore, other.lore)
            && java.util.Objects.equals(this.skullValue, other.skullValue)
            && java.util.Objects.equals(this.actions, other.actions);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(material, amount, name, lore, skullValue, actions);
    }

    @Override
    public String toString() {
        return "MCJavaItemDefinition[" +
            "material=" + this.material + ", " +
            "amount=" + this.amount + ", " +
            "name=" + this.name + ", " +
            "lore=" + this.lore + ", " +
            "skullValue=" + this.skullValue + ", " +
            "actions=" + this.actions +
            "]";
    }

    public static <M> MCJavaItemDefinition<M> of(M material, String name, List<String> lore, List<String> actions) {
        return new MCJavaItemDefinition<>(material, 1, name, lore, null, actions);
    }

    public static <M> MCJavaItemDefinition<M> of(M material, int amount, String name, List<String> lore,
                                                  List<String> actions) {
        return new MCJavaItemDefinition<>(material, amount, name, lore, null, actions);
    }

    public static <M> MCJavaItemDefinition<M> skull(M skullMaterial, String skullValue, String name,
                                                    List<String> lore, List<String> actions) {
        return new MCJavaItemDefinition<>(skullMaterial, 1, name, lore, skullValue, actions);
    }
}
