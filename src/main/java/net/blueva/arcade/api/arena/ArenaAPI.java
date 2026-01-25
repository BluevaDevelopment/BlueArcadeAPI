package net.blueva.arcade.api.arena;

import java.util.List;

/**
 * API for arena management and data access.
 */
public interface ArenaAPI<L, W> {

    int getArenaId();
    String getGameId();
    W getWorld();

    // Bounds
    L getBoundsMin();
    L getBoundsMax();
    boolean isInBounds(L loc);

    // Spawns
    List<L> getSpawns();
    L getRandomSpawn();

    // Finish line (if exists)
    boolean hasFinishLine();
    L getFinishMin();
    L getFinishMax();
    boolean isInFinishLine(L loc);

    // Floors (if exists)
    boolean hasFloors();
    List<FloorRegion<L>> getFloors();

    // Arena state
    boolean isEnabled();
    int getCurrentPlayers();
    int getMaxPlayers();
}
