package net.blueva.arcade.api.stats;

/**
 * Immutable definition of a statistic.
 * <p>
 * StatDefinitions declare trackable metrics for games, including their scope,
 * display information, and unique identifiers. They are used to register
 * statistics that can be tracked per player across games or specific modules.
 * </p>
 *
 * @param key the unique identifier for this stat (used in storage and queries)
 * @param displayName the user-friendly name shown in UIs and leaderboards
 * @param description a detailed description of what this stat tracks
 * @param scope the scope of this stat (GLOBAL or MODULE-specific)
 */
public record StatDefinition(
        String key,
        String displayName,
        String description,
        StatScope scope
) {

    public StatDefinition {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Stat key cannot be null or blank");
        }

        if (displayName == null || displayName.isBlank()) {
            displayName = key;
        }

        if (description == null) {
            description = "";
        }

        if (scope == null) {
            scope = StatScope.GLOBAL;
        }
    }
}
