package net.blueva.arcade.api.events;

/**
 * Event fired when a player attempts to join a game.
 * <p>
 * This event is cancellable. If cancelled, the player will not be allowed to join the game.
 * Game modules can listen to this event to implement custom join conditions or restrictions.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public class PlayerJoinGameEvent<P> extends GameEvent implements Cancellable {

    private final P player;
    private boolean cancelled = false;

    /**
     * Constructs a new PlayerJoinGameEvent.
     *
     * @param arenaId the ID of the arena the player is attempting to join
     * @param gameId the unique identifier of the game module
     * @param player the player attempting to join the game
     */
    public PlayerJoinGameEvent(int arenaId, String gameId, P player) {
        super(arenaId, gameId);
        this.player = player;
    }

    /**
     * Gets the player attempting to join the game.
     *
     * @return the player trying to join
     */
    public P getPlayer() {
        return player;
    }

    /**
     * Checks if this event has been cancelled.
     *
     * @return true if the join has been cancelled, false otherwise
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event.
     * <p>
     * If set to true, the player will not be allowed to join the game.
     * </p>
     *
     * @param cancel true to cancel the join, false to allow it
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
