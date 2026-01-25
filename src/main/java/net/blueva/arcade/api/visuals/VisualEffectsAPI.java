package net.blueva.arcade.api.visuals;

import org.jetbrains.annotations.Nullable;

/**
 * API for playing visual effects tied to store selections.
 */
public interface VisualEffectsAPI<P, L> {

    /**
     * Play the selected kill effect for the given player at their current location.
     *
     * @param killer player who earned the kill
     */
    void playKillEffect(P killer);

    /**
     * Play the selected kill effect for the given player at the provided location.
     *
     * @param killer player who earned the kill
     * @param location location to play the effect at (falls back to player location if null)
     */
    void playKillEffect(P killer, @Nullable L location);

    /**
     * Play the selected death effect for the given player at their current location.
     *
     * @param victim player who died
     */
    void playDeathEffect(P victim);

    /**
     * Play the selected death effect for the given player at the provided location.
     *
     * @param victim player who died
     * @param location location to play the effect at (falls back to player location if null)
     */
    void playDeathEffect(P victim, @Nullable L location);
}
