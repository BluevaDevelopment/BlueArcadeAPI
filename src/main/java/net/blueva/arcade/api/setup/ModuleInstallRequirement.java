package net.blueva.arcade.api.setup;

/**
 * Optional install-time requirement declared by a game module.
 *
 * @since 3.4
 */
public record ModuleInstallRequirement(
        String id,
        ModuleRequirementType type,
        boolean required,
        String displayName,
        String description,
        String installHint
) {
}
