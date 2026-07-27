package net.blueva.arcade.api.ui.sound.minecraft;

import net.blueva.arcade.api.ui.SoundsAPI;

/**
 * Minecraft-specific extension of {@link SoundsAPI}.
 * Provides built-in note-block song (.nbs) playback.
 *
 * @since 3.3
 */
public interface MCSoundsAPI<P, L, S> extends SoundsAPI<P, L, S> {

    /**
     * Play a NoteBlock song (.nbs file) for a player.
     * Replaces the deprecated {@link SoundsAPI#playNBS(Object, String)}.
     *
     * @param player  Player to play the song for
     * @param nbsFile NBS file path (relative to the module's sounds folder,
     *                without extension)
     */
    void playNBS(P player, String nbsFile);

    /**
     * Stop the NBS song currently playing for a player.
     *
     * @param player Player to stop the song for
     */
    void stopNBS(P player);
}
