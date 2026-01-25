package net.blueva.arcade.api.player;

/**
 * API for player management in games.
 */
public interface PlayerAPI<P> {

    GamePlayer<P> getGamePlayer(P player);
    boolean isInGame(P player);

    void sendToLobby(P player);
    void clearInventory(P player);
    void resetPlayer(P player);
}
