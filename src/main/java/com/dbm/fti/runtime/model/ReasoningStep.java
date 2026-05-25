package com.dbm.fti.runtime.model;

public class ReasoningStep {

    private final String id;
    private final String content;
    private final double evidenceScore;
    private final double policyScore;
    private final double coherenceScore;

    public ReasoningStep(
            String id,
            String content,
            double evidenceScore,
            double policyScore,
            double coherenceScore) {

        this.id = id;
        this.content = content;
        this.evidenceScore = evidenceScore;
        this.policyScore = policyScore;
        this.coherenceScore = coherenceScore;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getEvidenceScore() {
        return evidenceScore;
    }

    public double getPolicyScore() {
        return policyScore;
    }

    public double getCoherenceScore() {
        return coherenceScore;
    }
}