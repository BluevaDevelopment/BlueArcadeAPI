package net.blueva.arcade.api.world;

import java.util.List;
import java.util.Map;

/**
 * Represents a block pattern for games like Block Party, TNT Run, etc.
 * <p>
 * Block patterns define collections of blocks with their locations and materials.
 * They are used for games that manipulate floor blocks, such as removing random
 * blocks in TNT Run or matching colors in Block Party.
 * </p>
 *
 * @param <L> the location type (platform-specific)
 * @param <M> the material/block type (platform-specific)
 */
public interface BlockPattern<L, M> {

    /**
     * Gets all blocks in this pattern mapped to their locations.
     *
     * @return a map of locations to block materials
     */
    Map<L, M> getBlocks();

    /**
     * Gets all unique materials used in this pattern.
     * <p>
     * This is useful for games that need to select from available block types.
     * </p>
     *
     * @return a list of unique materials in the pattern
     */
    List<M> getMaterials();

    /**
     * Gets a random material from the pattern's available materials.
     * <p>
     * Commonly used in Block Party to select which color players must stand on.
     * </p>
     *
     * @return a randomly selected material from the pattern
     */
    M getRandomMaterial();

    /**
     * Applies this pattern to the world by placing all blocks.
     * <p>
     * This materializes the pattern, setting all blocks at their defined locations
     * to their configured materials.
     * </p>
     */
    void apply();
}
