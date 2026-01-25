package net.blueva.arcade.api.events;

/**
 * Event fired when a player leaves a game.
 * <p>
 * This event is triggered whenever a player exits a game, whether voluntarily or involuntarily.
 * The leave reason provides context about why the player left the game.
 * Game modules can listen to this event to handle player departures and update game state accordingly.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public class PlayerLeaveGameEvent<P> extends GameEvent {

    private final P player;
    private final LeaveReason reason;

    /**
     * Constructs a new PlayerLeaveGameEvent.
     *
     * @param arenaId the ID of the arena the player is leaving
     * @param gameId the unique identifier of the game module
     * @param player the player who is leaving the game
     * @param reason the reason why the player is leaving
     */
    public PlayerLeaveGameEvent(int arenaId, String gameId, P player, LeaveReason reason) {
        super(arenaId, gameId);
        this.player = player;
        this.reason = reason;
    }

    /**
     * Gets the player who is leaving the game.
     *
     * @return the player leaving the game
     */
    public P getPlayer() {
        return player;
    }

    /**
     * Gets the reason why the player is leaving.
     *
     * @return the leave reason
     */
    public LeaveReason getReason() {
        return reason;
    }

    /**
     * Represents the different reasons why a player can leave a game.
     */
    public enum LeaveReason {
        /**
         * The player voluntarily quit the game.
         * This is triggered when a player uses a leave command or exits normally.
         */
        QUIT,

        /**
         * The player disconnected from the server.
         * This occurs when the player loses connection to the server.
         */
        DISCONNECT,

        /**
         * The player was kicked from the game.
         * This happens when an administrator or game rule removes the player.
         */
        KICK,

        /**
         * The player left due to server shutdown.
         * This is triggered when the server is stopping or restarting.
         */
        SERVER_STOP
    }
}
