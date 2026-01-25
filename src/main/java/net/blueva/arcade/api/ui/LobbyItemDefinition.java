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
public record LobbyItemDefinition<M>(
        String id,
        M material,
        int slot,
        String displayName,
        List<String> lore,
        List<String> actions,
        boolean enabled
) {
}
