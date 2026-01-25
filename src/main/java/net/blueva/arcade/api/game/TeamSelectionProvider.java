package net.blueva.arcade.api.game;

/**
 * Optional interface for modules that expose team selection during lobby phases.
 */
public interface TeamSelectionProvider<P, L, W, M, I, S, B, E> {

    /**
     * Open the team selection menu for a player.
     *
     * @param context Game context for the current arena
     * @param player Player requesting the menu
     * @return true if the menu opened
     */
    boolean openTeamMenu(GameContext<P, L, W, M, I, S, B, E> context, P player);
}
