package net.blueva.arcade.api.events;

/**
 * Base class for all BlueArcade game events.
 * <p>
 * All game-related events extend this class and provide access to the arena ID
 * and game module ID where the event occurred. Events can be listened to using
 * the {@link CustomEventRegistry}.
 * </p>
 */
public abstract class GameEvent {

    private final int arenaId;
    private final String gameId;

    /**
     * Constructs a new game event.
     *
     * @param arenaId the ID of the arena where this event occurred
     * @param gameId the unique identifier of the game module
     */
    public GameEvent(int arenaId, String gameId) {
        this.arenaId = arenaId;
        this.gameId = gameId;
    }

    /**
     * Gets the ID of the arena where this event occurred.
     *
     * @return the arena ID
     */
    public int getArenaId() {
        return arenaId;
    }

    /**
     * Gets the unique identifier of the game module.
     *
     * @return the game module ID
     */
    public String getGameId() {
        return gameId;
    }
}
