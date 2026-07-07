package net.blueva.arcade.api.setup;

/**
 * Evaluates whether a module setup step is complete for a specific arena/game.
 *
 * @param <P> platform player type
 * @param <C> platform command sender type
 * @param <L> platform location type
 * @since 3.4
 */
@FunctionalInterface
public interface ModuleSetupStatusEvaluator<P, C, L> {
    boolean isComplete(SetupContext<P, C, L> context);
}
