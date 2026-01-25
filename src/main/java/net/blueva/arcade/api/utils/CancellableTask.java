package net.blueva.arcade.api.utils;

/**
 * Represents a task that can be cancelled.
 * <p>
 * This interface abstracts the underlying scheduler implementation, providing
 * a platform-agnostic way to manage scheduled tasks.
 * </p>
 */
public interface CancellableTask {

    /**
     * Cancels this task, preventing it from running again.
     */
    void cancel();

    /**
     * Checks if this task has been cancelled.
     *
     * @return true if the task was cancelled, false otherwise
     */
    boolean isCancelled();
}
