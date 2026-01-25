package net.blueva.arcade.api.events;

/**
 * Event fired when a player is eliminated from the game.
 * <p>
 * This event is triggered when a player's state changes to ELIMINATED.
 * The reason for elimination can vary depending on the game (e.g., death, timeout, rule violation).
 * Game modules can listen to this event to perform custom actions when players are eliminated.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public class PlayerEliminateEvent<P> extends GameEvent {

    private final P player;
    private final String reason;

    /**
     * Constructs a new PlayerEliminateEvent.
     *
     * @param arenaId the ID of the arena where the elimination occurred
     * @param gameId the unique identifier of the game module
     * @param player the player who was eliminated
     * @param reason the reason for the elimination (game-specific)
     */
    public PlayerEliminateEvent(int arenaId, String gameId, P player, String reason) {
        super(arenaId, gameId);
        this.player = player;
        this.reason = reason;
    }

    /**
     * Gets the player who was eliminated.
     *
     * @return the eliminated player
     */
    public P getPlayer() {
        return player;
    }

    /**
     * Gets the reason why the player was eliminated.
     *
     * @return a description of why the player was eliminated
     */
    public String getReason() {
        return reason;
    }
}
