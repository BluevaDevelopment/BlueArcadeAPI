package net.blueva.arcade.api.setup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Declarative setup step shown by the core in setup checklists and admin help.
 *
 * @since 3.4
 */
public final class ModuleSetupStep {

    private final String id;
    private final boolean required;
    private final String displayName;
    private final String description;
    private final List<String> commandExamples;
    private final String expectedInput;

    public ModuleSetupStep(String id, boolean required, String displayName, String description,
                           List<String> commandExamples) {
        this(id, required, displayName, description, commandExamples, null);
    }

    public ModuleSetupStep(String id, boolean required, String displayName, String description,
                           List<String> commandExamples, String expectedInput) {
        this.id = id;
        this.required = required;
        this.displayName = displayName;
        this.description = description;
        this.commandExamples = commandExamples == null
                ? Collections.<String>emptyList()
                : Collections.unmodifiableList(new ArrayList<String>(commandExamples));
        this.expectedInput = expectedInput;
    }

    public String id() {
        return this.id;
    }

    public boolean required() {
        return this.required;
    }

    public String displayName() {
        return this.displayName;
    }

    public String description() {
        return this.description;
    }

    public List<String> commandExamples() {
        return this.commandExamples;
    }

    public String expectedInput() {
        return this.expectedInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModuleSetupStep)) {
            return false;
        }
        ModuleSetupStep other = (ModuleSetupStep) o;
        return this.required == other.required
                && java.util.Objects.equals(this.id, other.id)
                && java.util.Objects.equals(this.displayName, other.displayName)
                && java.util.Objects.equals(this.description, other.description)
                && java.util.Objects.equals(this.commandExamples, other.commandExamples)
                && java.util.Objects.equals(this.expectedInput, other.expectedInput);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, required, displayName, description, commandExamples, expectedInput);
    }

    @Override
    public String toString() {
        return "ModuleSetupStep[" +
                "id=" + this.id + ", " +
                "required=" + this.required + ", " +
                "displayName=" + this.displayName + ", " +
                "description=" + this.description + ", " +
                "commandExamples=" + this.commandExamples + ", " +
                "expectedInput=" + this.expectedInput +
                "]";
    }
}
