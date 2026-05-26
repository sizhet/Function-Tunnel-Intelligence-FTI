package com.dbm.cpg.cpg;

import com.dbm.cpg.model.*;
import java.util.*;

public final class DerivationGenerator {
    public List<DerivativeCandidate> generate(CpaResult source) {
        List<DerivativeCandidate> out = new ArrayList<DerivativeCandidate>();
        out.add(distributedPlanner());
        out.add(unsafePlanner());
        out.add(incompletePlanner());
        return out;
    }

    private DerivativeCandidate distributedPlanner() {
        StructuralGraph g = new StructuralGraph("DistributedPlannerGraph")
                .addNode("plan", "PLAN")
                .addNode("validate", "VALIDATE")
                .addNode("dispatch", "DISPATCH")
                .addNode("workerExecute", "WORKER_EXECUTE")
                .addNode("trace", "TRACE")
                .addEdge("plan", "validate", "CALLS")
                .addEdge("validate", "dispatch", "CALLS")
                .addEdge("dispatch", "workerExecute", "CALLS")
                .addEdge("workerExecute", "trace", "CALLS");
        return new DerivativeCandidate("Candidate-A: DistributedPlannerGraph", g,
                Arrays.asList("Added DistributedDispatcher", "Added WorkerExecute adapter", "Preserved validation-before-execution order"));
    }

    private DerivativeCandidate unsafePlanner() {
        StructuralGraph g = new StructuralGraph("UnsafeFastPlannerGraph")
                .addNode("plan", "PLAN")
                .addNode("execute", "EXECUTE")
                .addNode("validate", "VALIDATE")
                .addNode("trace", "TRACE")
                .addEdge("plan", "execute", "CALLS")
                .addEdge("execute", "validate", "CALLS")
                .addEdge("validate", "trace", "CALLS");
        return new DerivativeCandidate("Candidate-B: UnsafeFastPlannerGraph", g,
                Arrays.asList("Moved execution before validation", "Keeps trace but violates ordering policy"));
    }

    private DerivativeCandidate incompletePlanner() {
        StructuralGraph g = new StructuralGraph("IncompletePlannerGraph")
                .addNode("plan", "PLAN")
                .addNode("validate", "VALIDATE")
                .addNode("execute", "EXECUTE")
                .addEdge("plan", "validate", "CALLS")
                .addEdge("validate", "execute", "CALLS");
        return new DerivativeCandidate("Candidate-C: IncompletePlannerGraph", g,
                Arrays.asList("Removed trace region", "Preserves main execution sequence but loses trace policy"));
    }
}
