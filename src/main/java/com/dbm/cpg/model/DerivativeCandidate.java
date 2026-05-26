package com.dbm.cpg.model;

import java.util.*;

public final class DerivativeCandidate {
    private final String name;
    private final StructuralGraph graph;
    private final List<String> changes;

    public DerivativeCandidate(String name, StructuralGraph graph, List<String> changes) {
        this.name = name;
        this.graph = graph;
        this.changes = new ArrayList<String>(changes);
    }

    public String getName() { return name; }
    public StructuralGraph getGraph() { return graph; }
    public List<String> getChanges() { return Collections.unmodifiableList(changes); }
}
