package net.blueva.arcade.api.setup;

/**
 * Optional runtime status check for a declared module setup step.
 *
 * @since 3.4
 */
public final class ModuleSetupStatusCheck<P, C, L> {

    private final String stepId;
    private final boolean requiredForEnable;
    private final String incompleteHint;
    private final ModuleSetupStatusEvaluator<P, C, L> evaluator;

    public ModuleSetupStatusCheck(String stepId, boolean requiredForEnable, String incompleteHint, ModuleSetupStatusEvaluator<P, C, L> evaluator) {
        this.stepId = stepId;
        this.requiredForEnable = requiredForEnable;
        this.incompleteHint = incompleteHint;
        this.evaluator = evaluator;
    }

    public String stepId() {
        return this.stepId;
    }

    public boolean requiredForEnable() {
        return this.requiredForEnable;
    }

    public String incompleteHint() {
        return this.incompleteHint;
    }

    public ModuleSetupStatusEvaluator<P, C, L> evaluator() {
        return this.evaluator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModuleSetupStatusCheck)) {
            return false;
        }
        ModuleSetupStatusCheck<?, ?, ?> other = (ModuleSetupStatusCheck<?, ?, ?>) o;
        return java.util.Objects.equals(this.stepId, other.stepId)
            && this.requiredForEnable == other.requiredForEnable
            && java.util.Objects.equals(this.incompleteHint, other.incompleteHint)
            && java.util.Objects.equals(this.evaluator, other.evaluator);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(stepId, requiredForEnable, incompleteHint, evaluator);
    }

    @Override
    public String toString() {
        return "ModuleSetupStatusCheck[" +
            "stepId=" + this.stepId + ", " +
            "requiredForEnable=" + this.requiredForEnable + ", " +
            "incompleteHint=" + this.incompleteHint + ", " +
            "evaluator=" + this.evaluator +
            "]";
    }
}
