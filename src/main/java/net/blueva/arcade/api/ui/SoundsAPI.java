package net.blueva.arcade.api.ui;

import java.util.List;

/**
 * API for playing sounds and music to players.
 */
public interface SoundsAPI<P, L, S> {

    /**
     * Play sound from module's sounds.yml by key.
     */
    void play(P player, String key);

    /**
     * Play Bukkit sound directly.
     */
    void play(P player, S sound, float volume, float pitch);

    /**
     * Play sound at location.
     */
    void playAt(L loc, String key);

    /**
     * Play NoteBlock song (.nbs file).
     */
    void playNBS(P player, String nbsFile);

    /**
     * Play random music from a list in sounds.yml.
     */
    void playRandomMusic(P player, List<String> sounds);

    /**
     * Stop music for player.
     */
    void stopMusic(P player);

    /**
     * Pause music for player without losing position.
     */
    void pauseMusic(P player);

    /**
     * Resume paused music for player.
     */
    void resumeMusic(P player);
}
