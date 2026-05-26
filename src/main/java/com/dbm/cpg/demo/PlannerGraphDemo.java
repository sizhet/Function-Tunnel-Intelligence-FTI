package com.dbm.cpg.demo;

import com.dbm.cpg.model.StructuralGraph;

public final class PlannerGraphDemo {
    private PlannerGraphDemo() {}

    public static StructuralGraph plannerGraph() {
        return new StructuralGraph("PlannerGraph")
                .addNode("plan", "PLAN")
                .addNode("validate", "VALIDATE")
                .addNode("execute", "EXECUTE")
                .addNode("trace", "TRACE")
                .addEdge("plan", "validate", "CALLS")
                .addEdge("validate", "execute", "CALLS")
                .addEdge("execute", "trace", "CALLS");
    }
}
