package net.blueva.arcade.api.setup;

import net.blueva.arcade.api.ui.MessageAPI;
import net.blueva.arcade.api.utils.SchedulerAPI;

/**
 * Context passed to setup handlers when executing commands.
 * <p>
 * This context contains all information needed to handle a setup command, including
 * the command sender, arena being configured, command arguments, and access to data
 * and selection APIs for arena configuration.
 * </p>
 *
 * @param <P> the player type (platform-specific)
 * @param <C> the command sender type (platform-specific)
 * @param <L> the location type (platform-specific)
 */
public class SetupContext<P, C, L> {

    private final C sender;
    private final P player; // null if sender is console
    private final int arenaId;
    private final String gameId;
    private final String[] args; // Full command args
    private final int startIndex; // Index where handler-specific args start
    private final SetupDataAPI<L> dataAPI;
    private final SetupSelectionAPI<P, L> selectionAPI;
    private final MessageAPI<P> messageAPI;
    private final SchedulerAPI<?, L> schedulerAPI;

    /**
     * @deprecated Use the constructor that accepts a {@link SchedulerAPI} parameter instead.
     */
    @Deprecated
    public SetupContext(C sender, P player, int arenaId, String gameId, String[] args, int startIndex,
                        SetupDataAPI<L> dataAPI, SetupSelectionAPI<P, L> selectionAPI, MessageAPI<P> messageAPI) {
        this(sender, player, arenaId, gameId, args, startIndex, dataAPI, selectionAPI, messageAPI, null);
    }

    /**
     * Creates a new setup context.
     *
     * @param sender       the command sender (player or console)
     * @param player       the player, or {@code null} if the sender is the console
     * @param arenaId      the arena being configured
     * @param gameId       the game module being configured
     * @param args         full command arguments
     * @param startIndex   index where handler-specific arguments start
     * @param dataAPI      data API for saving/loading game configuration
     * @param selectionAPI selection API for getting player position selections
     * @param messageAPI   message API for sending formatted messages
     * @param schedulerAPI scheduler API for running world-thread tasks from setup handlers
     * @since 3.2
     */
    public SetupContext(C sender, P player, int arenaId, String gameId, String[] args, int startIndex,
                        SetupDataAPI<L> dataAPI, SetupSelectionAPI<P, L> selectionAPI, MessageAPI<P> messageAPI,
                        SchedulerAPI<?, L> schedulerAPI) {
        this.sender = sender;
        this.player = player;
        this.arenaId = arenaId;
        this.gameId = gameId;
        this.args = args;
        this.startIndex = startIndex;
        this.dataAPI = dataAPI;
        this.selectionAPI = selectionAPI;
        this.messageAPI = messageAPI;
        this.schedulerAPI = schedulerAPI;
    }

    /**
     * Get command sender (player or console).
     */
    public C getSender() {
        return sender;
    }

    /**
     * Get player if sender is a player, null otherwise.
     */
    public P getPlayer() {
        return player;
    }

    /**
     * Check if sender is a player.
     */
    public boolean isPlayer() {
        return player != null;
    }

    /**
     * Get arena ID being configured.
     */
    public int getArenaId() {
        return arenaId;
    }

    /**
     * Get game ID being configured.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Get all command arguments.
     * Example: [game, 1, race, spawn, add] for "/baa game 1 race spawn add"
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * Get index where handler-specific arguments start.
     * For "/baa game 1 race spawn add", if handler handles "spawn", startIndex = 4
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Get argument at specific index, or null if out of bounds.
     */
    public String getArg(int index) {
        return index < args.length ? args[index] : null;
    }

    /**
     * Get handler-specific argument at relative index.
     * getHandlerArg(0) returns first arg after the handler subcommand.
     *
     * Example: "/baa game 1 race spawn add"
     * If handler handles "spawn", getHandlerArg(0) = "add"
     */
    public String getHandlerArg(int relativeIndex) {
        int absoluteIndex = startIndex + relativeIndex;
        return getArg(absoluteIndex);
    }

    /**
     * Get number of handler-specific arguments.
     */
    public int getHandlerArgCount() {
        return Math.max(0, args.length - startIndex);
    }

    /**
     * Check if handler has enough arguments.
     */
    public boolean hasHandlerArgs(int count) {
        return getHandlerArgCount() >= count;
    }

    /**
     * Get data API for saving/loading game configuration.
     */
    public SetupDataAPI<L> getData() {
        return dataAPI;
    }

    /**
     * Get selection API for getting player's position selections.
     */
    public SetupSelectionAPI<P, L> getSelection() {
        return selectionAPI;
    }

    public MessageAPI<P> getMessagesAPI() {
        return messageAPI;
    }

    /**
     * Get scheduler API for running world-thread tasks from setup handlers.
     * <p>
     * This allows setup handlers to schedule tasks on the world thread without
     * having to use {@code world.execute()} directly.
     * </p>
     *
     * @return the scheduler API, or {@code null} if not available
     * @since 3.2
     */
    public SchedulerAPI<?, L> getSchedulerAPI() {
        return schedulerAPI;
    }
}
