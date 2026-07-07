package net.blueva.arcade.api.setup;

import java.util.List;

/**
 * Declarative setup step shown by the core in setup checklists and admin help.
 *
 * @since 3.4
 */
public record ModuleSetupStep(
        String id,
        boolean required,
        String displayName,
        String description,
        List<String> commandExamples,
        String expectedInput
) {
    public ModuleSetupStep(String id, boolean required, String displayName, String description, List<String> commandExamples) {
        this(id, required, displayName, description, commandExamples, null);
    }

    public ModuleSetupStep {
        commandExamples = commandExamples == null ? List.of() : List.copyOf(commandExamples);
    }
}
