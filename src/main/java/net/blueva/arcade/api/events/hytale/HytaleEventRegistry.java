package net.blueva.arcade.api.events.hytale;

import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.component.system.ISystem;
import com.hypixel.hytale.component.system.RefChangeSystem;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import net.blueva.arcade.api.events.CustomEventRegistry;
import net.blueva.arcade.api.events.EventSubscription;

/**
 * Hytale-specific extension of {@link CustomEventRegistry} that exposes
 * ECS system registration without requiring reflection.
 *
 * <p>Modules cast the registry received in
 * {@code GameModule.registerEvents()} to this interface when they need
 * to register ECS systems:
 * <pre>{@code
 * if (registry instanceof HytaleEventRegistry hytaleRegistry) {
 *     hytaleRegistry.registerSystem(new MySystem(game));
 * }
 * }</pre>
 *
 * @since 3.3
 */
public interface HytaleEventRegistry
        extends CustomEventRegistry<EventSubscription<?>, Short> {

    /**
     * Register an entity-event ECS system.
     *
     * @param system system to register
     */
    void registerSystem(EntityEventSystem<EntityStore, ?> system);

    /**
     * Register an entity-ticking ECS system.
     *
     * @param system system to register
     */
    void registerSystem(EntityTickingSystem<EntityStore> system);

    /**
     * Register a ref-change ECS system.
     *
     * @param system system to register
     */
    void registerSystem(RefChangeSystem<EntityStore, ?> system);

    /**
     * Register a generic ECS system (e.g. death-tracking via ISystem).
     * Delegates to the entity-store registry internally.
     *
     * @param system system to register
     */
    void registerSystem(ISystem<EntityStore> system);
}
