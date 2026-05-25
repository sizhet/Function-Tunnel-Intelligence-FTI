package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.PolicyTunnel;
import com.dbm.fti.runtime.model.ReasoningStep;

public class TunnelScoringEngine {

    public double combinedScore(ReasoningStep step) {

        return (step.getEvidenceScore()
                + step.getPolicyScore()
                + step.getCoherenceScore()) / 3.0;
    }

    public boolean insideTunnel(
            ReasoningStep step,
            PolicyTunnel tunnel) {

        return step.getEvidenceScore() >= tunnel.getMinEvidenceScore()
                && step.getPolicyScore() >= tunnel.getMinPolicyScore()
                && step.getCoherenceScore() >= tunnel.getMinCoherenceScore()
                && combinedScore(step) >= tunnel.getMinCombinedScore();
    }
}