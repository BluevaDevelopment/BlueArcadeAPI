package net.blueva.arcade.api.store;

/**
 * Defines the visibility scope of a store category.
 * <p>
 * Store categories can be either globally available across all games or specific to
 * individual game modules.
 * </p>
 */
public enum StoreScope {
    /**
     * The category is globally available across all game modules.
     * Global categories are visible in the main store menu regardless of which game is being played.
     */
    GLOBAL,

    /**
     * The category is specific to a particular game module.
     * Module-specific categories are only visible when playing the associated game.
     */
    MODULE
}
