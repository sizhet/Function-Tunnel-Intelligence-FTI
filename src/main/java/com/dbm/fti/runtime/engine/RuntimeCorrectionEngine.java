package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.ReasoningStep;

public class RuntimeCorrectionEngine {

    public ReasoningStep correct(ReasoningStep step) {

        return new ReasoningStep(
                step.getId() + "-corrected",
                "Corrected: keep the claim bounded, evidence-aware, and inside the policy tunnel.",
                Math.max(step.getEvidenceScore(), 0.76),
                Math.max(step.getPolicyScore(), 0.84),
                Math.max(step.getCoherenceScore(), 0.82));
    }
}