package net.blueva.arcade.api.game;

import net.blueva.arcade.api.arena.ArenaAPI;
import net.blueva.arcade.api.config.*;
import net.blueva.arcade.api.module.ModuleInfo;
import net.blueva.arcade.api.player.GamePlayer;
import net.blueva.arcade.api.team.TeamsAPI;
import net.blueva.arcade.api.ui.*;
import net.blueva.arcade.api.utils.PlayerUtil;
import net.blueva.arcade.api.utils.SchedulerAPI;
import net.blueva.arcade.api.world.BlocksAPI;

import java.util.List;

/**
 * Provides runtime access to all game APIs and state during gameplay.
 * <p>
 * GameContext is the primary interface game modules use to interact with the game engine.
 * It provides access to player management, APIs for UI/world manipulation, game state,
 * and configuration. This context is available during all game lifecycle phases.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 * @param <L> the location type (platform-specific)
 * @param <W> the world type (platform-specific)
 * @param <M> the material/block type (platform-specific)
 * @param <I> the item stack type (platform-specific)
 * @param <S> the sound type (platform-specific)
 * @param <B> the block type (platform-specific)
 * @param <E> the entity type (platform-specific)
 */
public interface GameContext<P, L, W, M, I, S, B, E> {

    // === GAME DATA ===

    /**
     * Gets the ID of the arena this game is running in.
     *
     * @return the arena ID
     */
    int getArenaId();

    /**
     * Gets the unique identifier of this game module.
     *
     * @return the game module ID
     */
    String getGameId();

    /**
     * Gets the current phase of the game.
     *
     * @return the current game phase
     */
    GamePhase getPhase();

    /**
     * Sets the current phase of the game.
     * <p>
     * This should be used carefully as it affects game flow and lifecycle hooks.
     * </p>
     *
     * @param phase the new game phase
     */
    void setPhase(GamePhase phase);

    /**
     * Gets the current round number (1-based).
     *
     * @return the current round
     */
    int getCurrentRound();

    /**
     * Gets the maximum number of rounds configured for this game.
     *
     * @return the max rounds, or 1 if not a multi-round game
     */
    int getMaxRounds();

    /**
     * Checks if a location is within the arena boundaries.
     *
     * @param location the location to check
     * @return true if inside bounds, false otherwise
     */
    boolean isInsideBounds(L location);

    /**
     * Respawns a player at their designated spawn point.
     *
     * @param player the player to respawn
     */
    void respawnPlayer(P player);

    /**
     * Marks a player as having finished the game successfully.
     * <p>
     * This is typically used in race-type games when a player crosses the finish line.
     * </p>
     *
     * @param player the player who finished
     */
    void finishPlayer(P player);

    /**
     * Checks if a player is actively playing (not spectating or eliminated).
     *
     * @param player the player to check
     * @return true if the player is in PLAYING state
     */
    boolean isPlayerPlaying(P player);

    // === PLAYERS ===

    /**
     * Gets all players in the game (playing, spectating, and eliminated).
     *
     * @return list of all players in the arena
     */
    List<P> getPlayers();

    /**
     * Gets all players who are still actively playing (not eliminated or spectating).
     *
     * @return list of alive players
     */
    List<P> getAlivePlayers();

    /**
     * Gets all players who are spectating the game.
     *
     * @return list of spectator players
     */
    List<P> getSpectators();

    /**
     * Checks if a player is in this game.
     *
     * @param player the player to check
     * @return true if the player is in this game
     */
    boolean hasPlayer(P player);

    /**
     * Gets the GamePlayer wrapper for a specific player.
     *
     * @param player the platform player
     * @return the GamePlayer instance, or null if not in game
     */
    GamePlayer<P> getGamePlayer(P player);

    /**
     * Eliminates a player from the game with a specific reason.
     *
     * @param player the player to eliminate
     * @param reason the elimination reason (for events/logging)
     */
    void eliminatePlayer(P player, String reason);

    /**
     * Sets a single winner for the game.
     * <p>
     * This should be called when determining the game result.
     * </p>
     *
     * @param player the winning player
     */
    void setWinner(P player);

    /**
     * Marks multiple players as sharing first place (tie).
     *
     * @param players the players who tied for first
     */
    void markSharedFirstPlace(List<P> players);

    /**
     * Teleports all players to their assigned spawn points.
     */
    void teleportPlayersToSpawns();

    /**
     * Sets the list of players in the game.
     * <p>
     * This is typically used during game initialization.
     * </p>
     *
     * @param players the players to set
     */
    void setPlayers(List<P> players);

    // === APIS ===

    /**
     * Gets the Arena API for arena management.
     *
     * @return the arena API
     */
    ArenaAPI<L, W> getArenaAPI();

    /**
     * Gets the Blocks API for world manipulation.
     *
     * @return the blocks API
     */
    BlocksAPI<L, M, B> getBlocksAPI();

    /**
     * Gets the Message API for sending chat messages.
     *
     * @return the message API
     */
    MessageAPI<P> getMessagesAPI();

    /**
     * Gets the Titles API for displaying titles and subtitles.
     *
     * @return the titles API
     */
    TitlesAPI<P> getTitlesAPI();

    /**
     * Gets the Sounds API for playing sound effects.
     *
     * @return the sounds API
     */
    SoundsAPI<P, L, S> getSoundsAPI();

    /**
     * Gets the Scoreboard API for managing scoreboards.
     *
     * @return the scoreboard API
     */
    ScoreboardAPI<P> getScoreboardAPI();

    /**
     * Gets the Item API for item manipulation.
     *
     * @return the item API
     */
    ItemAPI<P, I, M> getItemAPI();

    /**
     * Gets the Hologram API for creating floating text displays.
     *
     * @return the hologram API
     */
    HologramAPI<L> getHologramAPI();

    /**
     * Gets the Scheduler API for running delayed/repeated tasks.
     *
     * @return the scheduler API
     */
    SchedulerAPI<E, L> getSchedulerAPI();

    /**
     * Gets the Teams API for team-based games.
     *
     * @return the teams API
     */
    TeamsAPI<P, M> getTeamsAPI();

    /**
     * Gets the Data Access API for reading arena configuration.
     *
     * @return the data access API
     */
    DataAccess<L> getDataAccess();

    /**
     * Gets the Player Util for player-related utilities.
     *
     * @return the player util
     */
    PlayerUtil<P> getPlayerUtil();

    /**
     * Gets the Config API for core configuration access.
     *
     * @return the config API
     */
    ConfigAPI getConfigAPI();

    /**
     * Gets the Vote Menu API for game voting.
     *
     * @return the vote menu API
     */
    VoteMenuAPI<M> getVoteMenuAPI();

    /**
     * Gets the Menu API for creating custom menus.
     *
     * @return the menu API
     */
    MenuAPI<P, M> getMenuAPI();

    /**
     * Gets the Core Config API for core settings.
     *
     * @return the core config API
     */
    CoreConfigAPI getCoreConfig();

    /**
     * Get module-specific configuration API.
     * Allows modules to manage multiple config files (config.yml, settings.yml, items.yml, etc.)
     *
     * @return ModuleConfigAPI instance for this game module
     */
    ModuleConfigAPI getModuleConfig();

    /**
     * Get module metadata from module.yml.
     * Provides access to module name, version, authors, etc.
     *
     * @return ModuleInfo with module metadata
     */
    ModuleInfo getModuleInfo();

    /**
     * @deprecated Use getModuleConfig() instead for better flexibility
     */
    @Deprecated
    ModuleSettings getSettings();

    // === GAME CONTROL ===

    /**
     * Ends the current game immediately.
     * <p>
     * This triggers the game ending sequence, including result calculation,
     * summary display, and rewards distribution.
     * </p>
     */
    void endGame();

    /**
     * Access summary and reward toggles for the current game session.
     *
     * @return mutable summary settings
     */
    SummarySettings getSummarySettings();
}
