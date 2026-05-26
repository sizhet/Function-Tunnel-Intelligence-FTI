package com.dbm.cpg.cpg;

import com.dbm.cpg.cpa.CpaEngine;
import com.dbm.cpg.model.*;
import java.util.*;

public final class CpgEngine {
    private final DerivationGenerator generator = new DerivationGenerator();
    private final PreservationValidator validator = new PreservationValidator();
    private final CandidateRanker ranker = new CandidateRanker();
    private final CpaEngine cpaEngine;

    public CpgEngine(CpaEngine cpaEngine) { this.cpaEngine = cpaEngine; }

    public List<PreservationReport> deriveAndValidate(CpaResult sourceAnalysis) {
        List<PreservationReport> reports = new ArrayList<PreservationReport>();
        for (DerivativeCandidate candidate : generator.generate(sourceAnalysis)) {
            CpaResult candidateAnalysis = cpaEngine.analyze(candidate.getGraph());
            reports.add(validator.validate(candidate, sourceAnalysis, candidateAnalysis));
        }
        return ranker.rank(reports);
    }
}
