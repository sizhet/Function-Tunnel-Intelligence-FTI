package com.dbm.cpg.cpg;

import com.dbm.cpg.model.*;
import java.util.*;

public final class PreservationValidator {
    public PreservationReport validate(DerivativeCandidate candidate, CpaResult source, CpaResult candidateAnalysis) {
        double core = source.getCoreCcc().overlap(candidateAnalysis.getCoreCcc());
        double policy = source.getPolicyCcc().overlap(candidateAnalysis.getPolicyCcc());
        RewriteDecision decision;
        if (core >= 1.0 && policy >= 1.0) decision = RewriteDecision.ACCEPT;
        else if (core >= 0.75 && policy >= 0.5) decision = RewriteDecision.REWRITE;
        else decision = RewriteDecision.REJECT;

        List<String> notes = new ArrayList<String>();
        notes.add("Core preservation score = " + core);
        notes.add("Policy preservation score = " + policy);
        if (decision == RewriteDecision.ACCEPT) notes.add("Candidate preserves required CCC and policy CCC.");
        if (decision == RewriteDecision.REWRITE) notes.add("Candidate is structurally close but needs repair.");
        if (decision == RewriteDecision.REJECT) notes.add("Candidate loses too much preserved structure.");
        return new PreservationReport(candidate, source, candidateAnalysis, core, policy, decision, notes);
    }
}
