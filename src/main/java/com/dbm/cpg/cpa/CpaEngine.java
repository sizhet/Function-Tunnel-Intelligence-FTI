package com.dbm.cpg.cpa;

import com.dbm.cpg.model.*;
import java.util.*;

public final class CpaEngine {
    private final SegmentationEngine segmentationEngine = new SegmentationEngine();
    private final CccExtractor cccExtractor = new CccExtractor();
    private final PolicyExtractor policyExtractor = new PolicyExtractor();
    private final CoreCompressor coreCompressor = new CoreCompressor();

    public CpaResult analyze(StructuralGraph graph) {
        List<String> roles = segmentationEngine.segmentRoles(graph);
        CoreCcc core = coreCompressor.canonicalize(cccExtractor.extract(roles));
        PolicyCcc policy = policyExtractor.extract(graph);
        return new CpaResult(graph, core, policy);
    }
}
