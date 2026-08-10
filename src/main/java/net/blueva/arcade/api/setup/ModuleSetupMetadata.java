package net.blueva.arcade.api.setup;

import java.util.Collections;

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
        return Collections.emptyList();
    }

    default List<ModuleSetupStep> getSetupSteps() {
        return Collections.emptyList();
    }

    default List<ModuleSetupCommand> getSetupCommands() {
        return Collections.emptyList();
    }

    default List<ModuleSetupStatusCheck<?, ?, ?>> getStatusChecks() {
        return Collections.emptyList();
    }
}
