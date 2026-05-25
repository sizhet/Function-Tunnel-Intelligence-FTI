package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.*;

public class RuntimeTunnelController {

    private final TunnelScoringEngine scoringEngine =
            new TunnelScoringEngine();

    private final RuntimeCorrectionEngine correctionEngine =
            new RuntimeCorrectionEngine();

    public StabilizationResult stabilize(
            ReasoningStep step,
            PolicyTunnel tunnel) {

        double beforeScore =
                scoringEngine.combinedScore(step);

        boolean beforeInside =
                scoringEngine.insideTunnel(step, tunnel);

        ReasoningStep stabilizedStep = step;

        if (!beforeInside) {
            stabilizedStep =
                    correctionEngine.correct(step);
        }

        double afterScore =
                scoringEngine.combinedScore(stabilizedStep);

        boolean afterInside =
                scoringEngine.insideTunnel(
                        stabilizedStep,
                        tunnel);

        return new StabilizationResult(
                step,
                stabilizedStep,
                beforeScore,
                afterScore,
                beforeInside,
                afterInside);
    }
}