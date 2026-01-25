package net.blueva.arcade.api.world;

import java.util.List;

/**
 * API for block manipulation in games.
 */
public interface BlocksAPI<L, M, B> {

    /**
     * Set a block at location.
     */
    void setBlock(L loc, M material);

    /**
     * Set blocks in a region.
     */
    void setRegion(L min, L max, M material);

    /**
     * Clear blocks in a region (set to AIR).
     */
    void clearRegion(L min, L max);

    /**
     * Apply a block pattern to the arena.
     */
    void applyPattern(BlockPattern<L, M> pattern);

    /**
     * Parse pattern from string list (from JSON data).
     */
    BlockPattern<L, M> parsePattern(List<String> patternData);

    /**
     * Regenerate floor to original state.
     */
    void regenerateFloor(int floorIndex);

    /**
     * Get block at location.
     */
    B getBlock(L loc);
}
