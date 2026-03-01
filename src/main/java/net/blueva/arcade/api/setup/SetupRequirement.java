package net.blueva.arcade.api.setup;

/**
 * Enumerates the default setup requirements that the core enforces during
 * arena configuration and enable/boot validation.
 * <p>
 * By default every requirement listed here is <b>active</b>. A module can
 * opt out of one or more requirements by returning them from
 * {@link net.blueva.arcade.api.game.GameModule#getDisabledRequirements()}.
 * When a requirement is disabled the core will:
 * <ul>
 *   <li>Skip the corresponding setup prompt during arena configuration.</li>
 *   <li>Skip validation for that requirement when enabling/booting the minigame.</li>
 * </ul>
 * </p>
 *
 * @since 3.2
 */
public enum SetupRequirement {

    /**
     * Arena boundary positions (pos1 / pos2).
     */
    BOUNDS,

    /**
     * Player spawn points.
     */
    SPAWNS,

    /**
     * Time-related values (time limit, countdown duration, etc.).
     */
    TIME
}
