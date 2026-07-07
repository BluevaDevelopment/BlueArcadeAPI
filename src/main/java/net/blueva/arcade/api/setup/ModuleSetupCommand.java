package net.blueva.arcade.api.setup;

/**
 * Human-readable documentation for a module-specific setup command.
 *
 * @since 3.4
 */
public record ModuleSetupCommand(
        String name,
        String usage,
        String description,
        boolean requiredForEnable
) {
}
