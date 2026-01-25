package net.blueva.arcade.api.game;

import java.util.List;

/**
 * Represents the result of a finished game.
 * <p>
 * This interface provides information about the outcome of a game, including the winner,
 * podium positions, all participating players, and whether the game was cancelled.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public interface GameResult<P> {

    /**
     * Gets the winner of the game.
     *
     * @return the winning player, or null if there is no winner
     */
    P getWinner();

    /**
     * Gets the top 3 players (podium) of the game.
     *
     * @return a list containing the top 3 players in order
     */
    List<P> getPodium();

    /**
     * Gets all players who participated in the game.
     *
     * @return a list of all players who were in the game
     */
    List<P> getAllPlayers();

    /**
     * Checks if the game has a winner.
     *
     * @return true if there is a winner, false otherwise
     */
    boolean hasWinner();

    /**
     * Checks if the game was cancelled before completion.
     *
     * @return true if the game was cancelled, false otherwise
     */
    boolean wasCancelled();

    /**
     * Gets the reason why the game was cancelled.
     *
     * @return the cancellation reason, or null if the game was not cancelled
     */
    String getCancelReason();
}
