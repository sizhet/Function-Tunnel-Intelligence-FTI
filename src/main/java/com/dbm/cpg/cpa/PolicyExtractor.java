package com.dbm.cpg.cpa;

import com.dbm.cpg.model.*;
import java.util.*;

public final class PolicyExtractor {
    public PolicyCcc extract(StructuralGraph graph) {
        List<String> policies = new ArrayList<String>();
        if (graph.hasRole("VALIDATE")) policies.add("VALIDATION_REQUIRED");
        if (graph.hasRole("TRACE")) policies.add("TRACE_REQUIRED");
        if (order(graph, "VALIDATE", "EXECUTE") || order(graph, "VALIDATE", "WORKER_EXECUTE")) {
            policies.add("VALIDATE_BEFORE_EXECUTE");
        }
        return new PolicyCcc(policies);
    }

    private boolean order(StructuralGraph graph, String before, String after) {
        int a = graph.indexOfRole(before);
        int b = graph.indexOfRole(after);
        return a >= 0 && b >= 0 && a < b;
    }
}
