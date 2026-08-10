package net.blueva.arcade.api.ui;

import java.util.List;

/**
 * Defines a lobby item that can be placed in the player's inventory during waiting phase.
 * <p>
 * Lobby items are interactive inventory items given to players while they wait for a game
 * to start. They can trigger various actions like opening menus, leaving the game, or
 * selecting teams. Items are configured per-game and can be enabled/disabled.
 * </p>
 *
 * @param <M> the material/item type (platform-specific)
 * @param id the unique identifier for this lobby item
 * @param material the material/item type to display
 * @param slot the inventory slot (0-8) where this item should be placed
 * @param displayName the colored display name shown to players
 * @param lore the list of lore lines shown in the item tooltip
 * @param actions the list of action commands to execute when clicked
 * @param enabled whether this lobby item is active and should be given to players
 */
public final class LobbyItemDefinition<M> {

    private final String id;
    private final M material;
    private final int slot;
    private final String displayName;
    private final List<String> lore;
    private final List<String> actions;
    private final boolean enabled;

    public LobbyItemDefinition(String id, M material, int slot, String displayName, List<String> lore, List<String> actions, boolean enabled) {
        this.id = id;
        this.material = material;
        this.slot = slot;
        this.displayName = displayName;
        this.lore = lore;
        this.actions = actions;
        this.enabled = enabled;
    }

    public String id() {
        return this.id;
    }

    public M material() {
        return this.material;
    }

    public int slot() {
        return this.slot;
    }

    public String displayName() {
        return this.displayName;
    }

    public List<String> lore() {
        return this.lore;
    }

    public List<String> actions() {
        return this.actions;
    }

    public boolean enabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LobbyItemDefinition)) {
            return false;
        }
        LobbyItemDefinition<?> other = (LobbyItemDefinition<?>) o;
        return java.util.Objects.equals(this.id, other.id)
            && java.util.Objects.equals(this.material, other.material)
            && this.slot == other.slot
            && java.util.Objects.equals(this.displayName, other.displayName)
            && java.util.Objects.equals(this.lore, other.lore)
            && java.util.Objects.equals(this.actions, other.actions)
            && this.enabled == other.enabled;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, material, slot, displayName, lore, actions, enabled);
    }

    @Override
    public String toString() {
        return "LobbyItemDefinition[" +
            "id=" + this.id + ", " +
            "material=" + this.material + ", " +
            "slot=" + this.slot + ", " +
            "displayName=" + this.displayName + ", " +
            "lore=" + this.lore + ", " +
            "actions=" + this.actions + ", " +
            "enabled=" + this.enabled +
            "]";
    }
}
