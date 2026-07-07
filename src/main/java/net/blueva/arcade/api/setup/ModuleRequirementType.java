package net.blueva.arcade.api.setup;

/**
 * Describes the kind of external dependency or install note a module may require.
 *
 * @since 3.4
 */
public enum ModuleRequirementType {
    PLUGIN,
    MODULE,
    PERMISSION,
    WORLD_RESOURCE,
    RESOURCE_PACK,
    OTHER
}
