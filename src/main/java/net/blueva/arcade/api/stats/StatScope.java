package net.blueva.arcade.api.stats;

/**
 * Defines the scope of a statistic definition.
 * <p>
 * Stats can be either globally tracked across all games or specific to individual
 * game modules. This allows for both universal statistics (like total wins) and
 * game-specific statistics (like blocks destroyed in TNT Run).
 * </p>
 */
public enum StatScope {
    /**
     * The statistic is globally tracked across all game modules.
     * <p>
     * Global stats include metrics like total games played, total wins, total kills, etc.
     * These are accumulated regardless of which game module is being played.
     * </p>
     */
    GLOBAL,

    /**
     * The statistic is specific to a particular game module.
     * <p>
     * Module-specific stats track game-unique metrics like "eggs thrown" in Egg Wars
     * or "laps completed" in Race games. These are only tracked for that specific game.
     * </p>
     */
    MODULE
}
