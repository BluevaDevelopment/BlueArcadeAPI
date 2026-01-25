package net.blueva.arcade.api.team;

import java.util.List;

/**
 * Read-only snapshot for a team in a game session.
 */
public interface TeamInfo<P, M> {

    /**
     * @return stable team identifier (used in commands and configs).
     */
    String getId();

    /**
     * @return display name for UI and messages.
     */
    String getDisplayName();

    /**
     * @return icon material for menus.
     */
    M getIcon();

    /**
     * @return maximum players allowed in the team.
     */
    int getMaxPlayers();

    /**
     * @return current number of players in the team.
     */
    int getPlayerCount();

    /**
     * @return online players currently assigned to this team.
     */
    List<P> getPlayers();

    /**
     * @return {@code true} if the team is full.
     */
    boolean isFull();
}
