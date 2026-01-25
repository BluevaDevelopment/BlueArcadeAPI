package net.blueva.arcade.api.events;

/**
 * Simple cancellable contract for platform-agnostic events.
 * <p>
 * Events implementing this interface can be cancelled by event handlers,
 * preventing the default action from occurring.
 * </p>
 */
public interface Cancellable {

    /**
     * Checks if this event has been cancelled.
     *
     * @return true if the event is cancelled, false otherwise
     */
    boolean isCancelled();

    /**
     * Sets the cancellation state of this event.
     *
     * @param cancelled true to cancel the event, false to allow it
     */
    void setCancelled(boolean cancelled);
}
