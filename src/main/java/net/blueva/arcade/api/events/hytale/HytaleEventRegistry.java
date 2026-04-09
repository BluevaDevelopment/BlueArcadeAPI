package net.blueva.arcade.api.events.hytale;

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
     * Register an ECS system (EntityEventSystem, EntityTickingSystem,
     * RefChangeSystem or ISystem). The implementation dispatches to the
     * appropriate typed overload at runtime.
     *
     * @param system system to register
     */
    void registerSystem(Object system);
}
