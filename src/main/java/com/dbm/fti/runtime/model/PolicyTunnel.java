package com.dbm.fti.runtime.model;

public class PolicyTunnel {

    private final double minEvidenceScore;
    private final double minPolicyScore;
    private final double minCoherenceScore;
    private final double minCombinedScore;

    public PolicyTunnel(
            double minEvidenceScore,
            double minPolicyScore,
            double minCoherenceScore,
            double minCombinedScore) {

        this.minEvidenceScore = minEvidenceScore;
        this.minPolicyScore = minPolicyScore;
        this.minCoherenceScore = minCoherenceScore;
        this.minCombinedScore = minCombinedScore;
    }

    public double getMinEvidenceScore() {
        return minEvidenceScore;
    }

    public double getMinPolicyScore() {
        return minPolicyScore;
    }

    public double getMinCoherenceScore() {
        return minCoherenceScore;
    }

    public double getMinCombinedScore() {
        return minCombinedScore;
    }
}