package net.blueva.arcade.api.setup;

/**
 * Optional runtime status check for a declared module setup step.
 *
 * @since 3.4
 */
public record ModuleSetupStatusCheck<P, C, L>(
        String stepId,
        boolean requiredForEnable,
        String incompleteHint,
        ModuleSetupStatusEvaluator<P, C, L> evaluator
) {
}
