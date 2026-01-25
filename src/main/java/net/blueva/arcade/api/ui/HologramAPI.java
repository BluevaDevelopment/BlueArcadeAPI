package net.blueva.arcade.api.ui;

import java.util.List;

/**
 * API for spawning and managing holograms in modules.
 */
public interface HologramAPI<L> {

    /**
     * Spawn a hologram at the given location with the provided text lines.
     *
     * @param arenaId  arena identifier used for cleanup
     * @param location base location where the hologram should appear
     * @param lines    lines to render (top to bottom)
     * @return spawned hologram instance, or null if creation failed
     */
    Hologram<L> spawn(int arenaId, L location, List<String> lines);

    /**
     * Delete all holograms associated with a specific arena.
     *
     * @param arenaId arena identifier
     */
    void deleteArenaHolograms(int arenaId);
}
