package net.blueva.arcade.api.setup;

import java.util.List;

/**
 * Interface for game-specific setup command handlers.
 * Each game module implements this to handle its own configuration commands.
 *
 * Example: RaceSetup handles "finishline" commands for race game
 */
public interface GameSetupHandler {

    /**
     * Handle a setup command.
     *
     * @param context Command context with sender, arena, args, etc.
     * @return true if command was handled successfully
     */
    boolean handle(SetupContext context);

    /**
     * Provide tab completion suggestions.
     *
     * @param context Tab completion context
     * @return Tab completion result with suggestions
     */
    TabCompleteResult tabComplete(TabCompleteContext context);

    /**
     * Get list of subcommands this handler supports.
     * Used for help messages and validation.
     *
     * Common subcommands are handled by core (bounds, spawn, time, etc.)
     * Only return game-specific subcommands here.
     *
     * @return List of supported subcommands (e.g., ["finishline", "laps"])
     */
    List<String> getSubcommands();

    /**
     * Validates if the game is fully configured and can be enabled.
     * <p>
     * This method is called by the core system when attempting to enable an arena.
     * Game modules can implement custom validation logic to ensure all required
     * configuration is present before allowing the arena to be activated.
     * </p>
     *
     * @param context setup context with data access for validation
     * @return true if the game is properly configured, false otherwise
     */
    default boolean validateConfig(SetupContext context) {
        return true; // Default: assume valid
    }
}
