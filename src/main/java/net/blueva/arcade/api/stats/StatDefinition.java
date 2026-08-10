package net.blueva.arcade.api.stats;

/**
 * Immutable definition of a statistic.
 * <p>
 * StatDefinitions declare trackable metrics for games, including their scope,
 * display information, and unique identifiers. They are used to register
 * statistics that can be tracked per player across games or specific modules.
 * </p>
 */
public final class StatDefinition {

    private final String key;
    private final String displayName;
    private final String description;
    private final StatScope scope;

    /**
     * @param key the unique identifier for this stat (used in storage and queries)
     * @param displayName the user-friendly name shown in UIs and leaderboards, defaulting to the key
     * @param description a detailed description of what this stat tracks, defaulting to empty
     * @param scope the scope of this stat (GLOBAL or MODULE-specific), defaulting to GLOBAL
     */
    public StatDefinition(String key, String displayName, String description, StatScope scope) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Stat key cannot be null or blank");
        }

        if (displayName == null || displayName.trim().isEmpty()) {
            displayName = key;
        }

        if (description == null) {
            description = "";
        }

        if (scope == null) {
            scope = StatScope.GLOBAL;
        }

        this.key = key;
        this.displayName = displayName;
        this.description = description;
        this.scope = scope;
    }

    public String key() {
        return this.key;
    }

    public String displayName() {
        return this.displayName;
    }

    public String description() {
        return this.description;
    }

    public StatScope scope() {
        return this.scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StatDefinition)) {
            return false;
        }
        StatDefinition other = (StatDefinition) o;
        return java.util.Objects.equals(this.key, other.key)
                && java.util.Objects.equals(this.displayName, other.displayName)
                && java.util.Objects.equals(this.description, other.description)
                && java.util.Objects.equals(this.scope, other.scope);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(key, displayName, description, scope);
    }

    @Override
    public String toString() {
        return "StatDefinition[" +
                "key=" + this.key + ", " +
                "displayName=" + this.displayName + ", " +
                "description=" + this.description + ", " +
                "scope=" + this.scope +
                "]";
    }
}
