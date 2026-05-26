package com.dbm.cpg.model;

import java.util.*;

public final class PreservationReport {
    private final DerivativeCandidate candidate;
    private final CpaResult sourceAnalysis;
    private final CpaResult candidateAnalysis;
    private final double coreScore;
    private final double policyScore;
    private final RewriteDecision decision;
    private final List<String> notes;

    public PreservationReport(DerivativeCandidate candidate, CpaResult sourceAnalysis, CpaResult candidateAnalysis,
                              double coreScore, double policyScore, RewriteDecision decision, List<String> notes) {
        this.candidate = candidate;
        this.sourceAnalysis = sourceAnalysis;
        this.candidateAnalysis = candidateAnalysis;
        this.coreScore = coreScore;
        this.policyScore = policyScore;
        this.decision = decision;
        this.notes = new ArrayList<String>(notes);
    }

    public DerivativeCandidate getCandidate() { return candidate; }
    public CpaResult getSourceAnalysis() { return sourceAnalysis; }
    public CpaResult getCandidateAnalysis() { return candidateAnalysis; }
    public double getCoreScore() { return coreScore; }
    public double getPolicyScore() { return policyScore; }
    public RewriteDecision getDecision() { return decision; }
    public List<String> getNotes() { return Collections.unmodifiableList(notes); }

    public double totalScore() { return 0.7 * coreScore + 0.3 * policyScore; }
}
