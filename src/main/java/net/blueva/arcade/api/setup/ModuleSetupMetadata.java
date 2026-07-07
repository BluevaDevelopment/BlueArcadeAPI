package net.blueva.arcade.api.setup;

import java.util.List;

/**
 * Optional declarative setup and install metadata for game modules.
 * <p>
 * This metadata is guidance for admin UI, setup checklists, diagnostics, and help text.
 * Existing {@link GameSetupHandler#getSubcommands()} and
 * {@link GameSetupHandler#validateConfig(SetupContext)} remain the runtime command and
 * enable-validation authorities for backward compatibility.
 * </p>
 *
 * @since 3.4
 */
public interface ModuleSetupMetadata {

    ModuleSetupMetadata EMPTY = new ModuleSetupMetadata() {
    };

    static ModuleSetupMetadata empty() {
        return EMPTY;
    }

    default List<ModuleInstallRequirement> getInstallRequirements() {
        return List.of();
    }

    default List<ModuleSetupStep> getSetupSteps() {
        return List.of();
    }

    default List<ModuleSetupCommand> getSetupCommands() {
        return List.of();
    }

    default List<ModuleSetupStatusCheck<?, ?, ?>> getStatusChecks() {
        return List.of();
    }
}
