package net.blueva.arcade.api.setup;

/**
 * Optional install-time requirement declared by a game module.
 *
 * @since 3.4
 */
public final class ModuleInstallRequirement {

    private final String id;
    private final ModuleRequirementType type;
    private final boolean required;
    private final String displayName;
    private final String description;
    private final String installHint;

    public ModuleInstallRequirement(String id, ModuleRequirementType type, boolean required, String displayName, String description, String installHint) {
        this.id = id;
        this.type = type;
        this.required = required;
        this.displayName = displayName;
        this.description = description;
        this.installHint = installHint;
    }

    public String id() {
        return this.id;
    }

    public ModuleRequirementType type() {
        return this.type;
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

    public String installHint() {
        return this.installHint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModuleInstallRequirement)) {
            return false;
        }
        ModuleInstallRequirement other = (ModuleInstallRequirement) o;
        return java.util.Objects.equals(this.id, other.id)
            && java.util.Objects.equals(this.type, other.type)
            && this.required == other.required
            && java.util.Objects.equals(this.displayName, other.displayName)
            && java.util.Objects.equals(this.description, other.description)
            && java.util.Objects.equals(this.installHint, other.installHint);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, type, required, displayName, description, installHint);
    }

    @Override
    public String toString() {
        return "ModuleInstallRequirement[" +
            "id=" + this.id + ", " +
            "type=" + this.type + ", " +
            "required=" + this.required + ", " +
            "displayName=" + this.displayName + ", " +
            "description=" + this.description + ", " +
            "installHint=" + this.installHint +
            "]";
    }
}
