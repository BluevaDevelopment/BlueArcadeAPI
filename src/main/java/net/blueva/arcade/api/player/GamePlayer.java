package net.blueva.arcade.api.player;

/**
 * Represents a player participating in a game session.
 * <p>
 * GamePlayer wraps a platform-specific player object and provides game-specific
 * state management, including player status (alive/spectator/eliminated) and
 * custom data storage for game modules.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 */
public interface GamePlayer<P> {

    /**
     * Gets the underlying platform-specific player object.
     *
     * @return the platform player
     */
    P getPlayer();

    /**
     * Gets the current state of this player in the game.
     *
     * @return the player's state (PLAYING, SPECTATOR, or ELIMINATED)
     */
    PlayerState getState();

    /**
     * Checks if the player is alive and actively playing.
     *
     * @return true if the player is in PLAYING state
     */
    boolean isAlive();

    /**
     * Checks if the player is spectating the game.
     *
     * @return true if the player is in SPECTATOR state
     */
    boolean isSpectator();

    /**
     * Checks if the player has been eliminated from the game.
     *
     * @return true if the player is in ELIMINATED state
     */
    boolean isEliminated();

    /**
     * Sets the player's state.
     *
     * @param state the new player state
     */
    void setState(PlayerState state);

    /**
     * Eliminates this player from the game with a reason.
     * <p>
     * This sets the player state to ELIMINATED and fires a PlayerEliminateEvent.
     * </p>
     *
     * @param reason the reason for elimination (for events/logging)
     */
    void eliminate(String reason);

    /**
     * Converts this player into a spectator.
     * <p>
     * This sets the player state to SPECTATOR.
     * </p>
     */
    void makeSpectator();

    // Game-specific data

    /**
     * Stores custom game-specific data for this player.
     * <p>
     * Game modules can use this to store temporary player data that persists
     * for the duration of the game session.
     * </p>
     *
     * @param key the data key
     * @param value the data value to store
     */
    void setData(String key, Object value);

    /**
     * Retrieves custom game-specific data for this player.
     *
     * @param <T> the expected type
     * @param key the data key
     * @param type the class of the expected type
     * @return the stored value, or null if not found
     */
    <T> T getData(String key, Class<T> type);

    /**
     * Checks if custom data exists for a given key.
     *
     * @param key the data key to check
     * @return true if data exists for this key, false otherwise
     */
    boolean hasData(String key);

    /**
     * Clears all custom data for this player.
     */
    void clearData();
}
