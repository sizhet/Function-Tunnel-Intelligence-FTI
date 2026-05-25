package com.dbm.fti.runtime.model;

public class StabilizationResult {

    private final ReasoningStep originalStep;
    private final ReasoningStep stabilizedStep;
    private final double combinedScoreBefore;
    private final double combinedScoreAfter;
    private final boolean insideTunnelBefore;
    private final boolean insideTunnelAfter;

    public StabilizationResult(
            ReasoningStep originalStep,
            ReasoningStep stabilizedStep,
            double combinedScoreBefore,
            double combinedScoreAfter,
            boolean insideTunnelBefore,
            boolean insideTunnelAfter) {

        this.originalStep = originalStep;
        this.stabilizedStep = stabilizedStep;
        this.combinedScoreBefore = combinedScoreBefore;
        this.combinedScoreAfter = combinedScoreAfter;
        this.insideTunnelBefore = insideTunnelBefore;
        this.insideTunnelAfter = insideTunnelAfter;
    }

    public ReasoningStep getOriginalStep() {
        return originalStep;
    }

    public ReasoningStep getStabilizedStep() {
        return stabilizedStep;
    }

    public double getCombinedScoreBefore() {
        return combinedScoreBefore;
    }

    public double getCombinedScoreAfter() {
        return combinedScoreAfter;
    }

    public boolean isInsideTunnelBefore() {
        return insideTunnelBefore;
    }

    public boolean isInsideTunnelAfter() {
        return insideTunnelAfter;
    }
}