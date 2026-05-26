package com.dbm.cpg.model;

public final class CpaResult {
    private final StructuralGraph graph;
    private final CoreCcc coreCcc;
    private final PolicyCcc policyCcc;

    public CpaResult(StructuralGraph graph, CoreCcc coreCcc, PolicyCcc policyCcc) {
        this.graph = graph;
        this.coreCcc = coreCcc;
        this.policyCcc = policyCcc;
    }

    public StructuralGraph getGraph() { return graph; }
    public CoreCcc getCoreCcc() { return coreCcc; }
    public PolicyCcc getPolicyCcc() { return policyCcc; }
}
