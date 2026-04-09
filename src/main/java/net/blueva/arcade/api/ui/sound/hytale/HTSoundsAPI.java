package net.blueva.arcade.api.ui.sound.hytale;

import net.blueva.arcade.api.ui.SoundsAPI;

import java.util.List;

/**
 * Hytale-specific extension of {@link SoundsAPI}.
 * Provides MIDI playback support through the BlueArcade instrument pipeline.
 *
 * @since 3.3
 */
public interface HTSoundsAPI<P, L, S> extends SoundsAPI<P, L, S> {

    /**
     * Play a MIDI melody for a player.
     * The {@code midiId} is a path relative to the module's {@code sounds/} folder,
     * without the {@code .midi} extension (e.g. {@code "effect/finish_game"}).
     *
     * @param player Player to play the melody for
     * @param midiId MIDI asset identifier
     */
    void playMIDI(P player, String midiId);

    /**
     * Stop any MIDI melody currently playing for a player.
     *
     * @param player Player to stop the melody for
     */
    void stopMIDI(P player);

    /**
     * Play a random MIDI melody from a list of IDs.
     *
     * @param player  Player to play the melody for
     * @param midiIds List of MIDI asset identifiers
     */
    default void playRandomMIDI(P player, List<String> midiIds) {
        if (midiIds == null || midiIds.isEmpty()) {
            return;
        }
        int index = (int) (Math.random() * midiIds.size());
        playMIDI(player, midiIds.get(index));
    }
}
