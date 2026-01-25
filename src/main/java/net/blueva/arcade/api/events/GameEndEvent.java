package net.blueva.arcade.api.events;

import net.blueva.arcade.api.game.GameResult;

/**
 * Event fired when a game ends.
 * <p>
 * This event is triggered when the game transitions to the ENDING phase.
 * It provides access to the complete game result, including winner, podium, and all players.
 * Game modules can listen to this event to perform cleanup or final statistics processing.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public class GameEndEvent<P> extends GameEvent {

    private final GameResult<P> result;

    /**
     * Constructs a new GameEndEvent.
     *
     * @param arenaId the ID of the arena where the game ended
     * @param gameId the unique identifier of the game module
     * @param result the final result of the game
     */
    public GameEndEvent(int arenaId, String gameId, GameResult<P> result) {
        super(arenaId, gameId);
        this.result = result;
    }

    /**
     * Gets the result of the ended game.
     *
     * @return the game result containing winner, podium, and all players
     */
    public GameResult<P> getResult() {
        return result;
    }
}
