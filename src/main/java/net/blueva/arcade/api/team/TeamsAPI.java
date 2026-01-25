package net.blueva.arcade.api.team;

import java.util.List;

/**
 * API for team-based game sessions.
 */
public interface TeamsAPI<P, M> {

    /**
     * @return {@code true} if the current game session uses teams.
     */
    boolean isEnabled();

    /**
     * @return number of teams configured for the current game.
     */
    int getTeamCount();

    /**
     * @return max size per team.
     */
    int getTeamSize();

    /**
     * @return all available teams.
     */
    List<TeamInfo<P, M>> getTeams();

    /**
     * Resolve a team by its id.
     *
     * @param teamId Team identifier
     * @return team info or {@code null} if not found
     */
    TeamInfo<P, M> getTeam(String teamId);

    /**
     * @param player player to check
     * @return team info or {@code null} if the player is not assigned
     */
    TeamInfo<P, M> getTeam(P player);

    /**
     * Assign a player to a specific team.
     *
     * @param player player to assign
     * @param teamId team identifier
     * @return {@code true} if the assignment succeeded
     */
    boolean assignPlayer(P player, String teamId);

    /**
     * Assign a player to the best available team automatically.
     *
     * @param player player to assign
     * @return {@code true} if the assignment succeeded
     */
    boolean autoAssignPlayer(P player);

    /**
     * Remove a player from their current team.
     *
     * @param player player to remove
     */
    void removePlayer(P player);

    /**
     * Clear all teams for the current session.
     */
    void clear();

    /**
     * Mark the winning team for summaries.
     *
     * @param teamId team identifier
     */
    void setWinningTeam(String teamId);

    /**
     * Mark multiple winning teams (ties) for summaries.
     *
     * @param teamIds team identifiers
     */
    void setWinningTeams(List<String> teamIds);

    /**
     * @return list of winning teams for the current session.
     */
    List<TeamInfo<P, M>> getWinningTeams();
}
