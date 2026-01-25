package net.blueva.arcade.api.setup;

/**
 * Context passed to setup handlers for tab completion.
 * <p>
 * This context provides information about the command being typed, including the current
 * argument index and all previous arguments. Handlers use this to provide relevant
 * suggestions for command completion.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 * @param <C> the command sender type (platform-specific)
 */
public class TabCompleteContext<P, C> {

    private final C sender;
    private final P player;
    private final int arenaId;
    private final String gameId;
    private final String[] args;
    private final int startIndex;
    private final int currentArgIndex;

    public TabCompleteContext(C sender, P player, int arenaId, String gameId,
                              String[] args, int startIndex, int currentArgIndex) {
        this.sender = sender;
        this.player = player;
        this.arenaId = arenaId;
        this.gameId = gameId;
        this.args = args;
        this.startIndex = startIndex;
        this.currentArgIndex = currentArgIndex;
    }

    public C getSender() {
        return sender;
    }

    public P getPlayer() {
        return player;
    }

    public boolean isPlayer() {
        return player != null;
    }

    public int getArenaId() {
        return arenaId;
    }

    public String getGameId() {
        return gameId;
    }

    public String[] getArgs() {
        return args;
    }

    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Get the index of the argument currently being completed.
     */
    public int getCurrentArgIndex() {
        return currentArgIndex;
    }

    /**
     * Get the relative index being completed (relative to handler start).
     */
    public int getRelativeArgIndex() {
        return currentArgIndex - startIndex;
    }

    /**
     * Get the argument at specific index.
     */
    public String getArg(int index) {
        return index < args.length ? args[index] : "";
    }

    /**
     * Get the argument currently being typed.
     */
    public String getCurrentArg() {
        return getArg(currentArgIndex);
    }

    /**
     * Get previous argument (before the one being typed).
     */
    public String getPreviousArg() {
        return currentArgIndex > 0 ? getArg(currentArgIndex - 1) : "";
    }
}
