package net.blueva.arcade.api.utils;

/**
 * Scheduler API with task management.
 */
public interface SchedulerAPI<E, L> {

    /**
     * Run task later (in ticks).
     * @param taskId Unique identifier for this task (e.g., "arena_5_race_timer")
     * @param task Task to run
     * @param delayTicks Delay in ticks
     */
    void runLater(String taskId, Runnable task, long delayTicks);

    /**
     * Run repeating task.
     * @param taskId Unique identifier for this task (e.g., "arena_5_race_timer")
     * @param task Task to run
     * @param delayTicks Initial delay in ticks
     * @param periodTicks Period between executions in ticks
     */
    void runTimer(String taskId, Runnable task, long delayTicks, long periodTicks);

    /**
     * Run task at entity location (Folia-safe).
     */
    void runAtEntity(E entity, Runnable task);

    /**
     * Run task at location (Folia-safe).
     */
    void runAtLocation(L location, Runnable task);

    /**
     * Cancel a specific task by ID.
     * @param taskId Task identifier
     */
    void cancelTask(String taskId);

    /**
     * Cancel all tasks for a specific arena.
     * @param arenaId Arena ID
     */
    void cancelArenaTasks(int arenaId);

    /**
     * Cancel all tasks for a specific game module.
     * @param moduleId Module ID (e.g., "race")
     */
    void cancelModuleTasks(String moduleId);

    /**
     * Cancel all tasks.
     */
    void cancelAllTasks();

    /**
     * Check if a task is running.
     * @param taskId Task identifier
     * @return true if task exists and is running
     */
    boolean isTaskRunning(String taskId);
}
