package net.blueva.arcade.api.ui;

import java.util.List;
import java.util.UUID;

/**
 * Represents a hologram spawned in the world.
 */
public interface Hologram<L> {

    /**
     * Get the UUID of the underlying entity.
     */
    UUID getId();

    /**
     * Get the current location of the hologram.
     */
    L getLocation();

    /**
     * Update the displayed lines.
     */
    void setLines(List<String> lines);

    /**
     * Teleport the hologram to a new location.
     */
    void teleport(L location);

    /**
     * Remove the hologram entity from the world.
     */
    void delete();
}
