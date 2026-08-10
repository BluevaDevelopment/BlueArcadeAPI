package net.blueva.arcade.api.setup;

/**
 * Human-readable documentation for a module-specific setup command.
 *
 * @since 3.4
 */
public final class ModuleSetupCommand {

    private final String name;
    private final String usage;
    private final String description;
    private final boolean requiredForEnable;

    public ModuleSetupCommand(String name, String usage, String description, boolean requiredForEnable) {
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.requiredForEnable = requiredForEnable;
    }

    public String name() {
        return this.name;
    }

    public String usage() {
        return this.usage;
    }

    public String description() {
        return this.description;
    }

    public boolean requiredForEnable() {
        return this.requiredForEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModuleSetupCommand)) {
            return false;
        }
        ModuleSetupCommand other = (ModuleSetupCommand) o;
        return java.util.Objects.equals(this.name, other.name)
            && java.util.Objects.equals(this.usage, other.usage)
            && java.util.Objects.equals(this.description, other.description)
            && this.requiredForEnable == other.requiredForEnable;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, usage, description, requiredForEnable);
    }

    @Override
    public String toString() {
        return "ModuleSetupCommand[" +
            "name=" + this.name + ", " +
            "usage=" + this.usage + ", " +
            "description=" + this.description + ", " +
            "requiredForEnable=" + this.requiredForEnable +
            "]";
    }
}
