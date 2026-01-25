package net.blueva.arcade.api.events;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Platform-agnostic event registration wrapper.
 * <p>
 * This is intended for platforms where event registration requires both
 * an event class and a handler reference (e.g. Hytale's EventRegistry).
 *
 * @param <E> Event type handled by the subscription.
 */
public final class EventSubscription<E> {

    private final Class<E> eventClass;
    private final Consumer<E> handler;

    /**
     * Constructs a new event subscription.
     *
     * @param eventClass the event class to listen for
     * @param handler the consumer that will handle the event
     * @throws NullPointerException if eventClass or handler is null
     */
    public EventSubscription(Class<E> eventClass, Consumer<E> handler) {
        this.eventClass = Objects.requireNonNull(eventClass, "eventClass");
        this.handler = Objects.requireNonNull(handler, "handler");
    }

    /**
     * Gets the event class this subscription listens for.
     *
     * @return the event class
     */
    public Class<E> getEventClass() {
        return eventClass;
    }

    /**
     * Gets the handler that processes the event.
     *
     * @return the event handler consumer
     */
    public Consumer<E> getHandler() {
        return handler;
    }
}
