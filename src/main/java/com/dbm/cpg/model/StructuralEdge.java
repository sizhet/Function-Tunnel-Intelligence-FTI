package com.dbm.cpg.model;

public final class StructuralEdge {
    private final String from;
    private final String to;
    private final String relation;

    public StructuralEdge(String from, String to, String relation) {
        if (from == null || to == null) throw new IllegalArgumentException("from/to are required");
        this.from = from;
        this.to = to;
        this.relation = relation == null ? "CALLS" : relation;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getRelation() { return relation; }

    @Override public String toString() { return from + " -[" + relation + "]-> " + to; }
}
