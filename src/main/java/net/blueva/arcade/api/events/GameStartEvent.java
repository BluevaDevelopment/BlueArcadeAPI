package net.blueva.arcade.api.events;

import java.util.List;

/**
 * Event fired when a game starts.
 * <p>
 * This event is triggered when the game transitions from the COUNTDOWN phase to the PLAYING phase.
 * It provides access to all players who are participating in the game at the start.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public class GameStartEvent<P> extends GameEvent {

    private final List<P> players;

    /**
     * Constructs a new GameStartEvent.
     *
     * @param arenaId the ID of the arena where the game is starting
     * @param gameId the unique identifier of the game module
     * @param players the list of all players participating in the game
     */
    public GameStartEvent(int arenaId, String gameId, List<P> players) {
        super(arenaId, gameId);
        this.players = players;
    }

    /**
     * Gets the list of all players who are participating in the game.
     *
     * @return an immutable list of all players at game start
     */
    public List<P> getPlayers() {
        return players;
    }
}
