package com.dbm.cpg.model;

import java.util.*;

public final class CpgCpaResult {
    private final CpaResult sourceAnalysis;
    private final List<PreservationReport> reports;

    public CpgCpaResult(CpaResult sourceAnalysis, List<PreservationReport> reports) {
        this.sourceAnalysis = sourceAnalysis;
        this.reports = new ArrayList<PreservationReport>(reports);
    }

    public CpaResult getSourceAnalysis() { return sourceAnalysis; }
    public List<PreservationReport> getReports() { return Collections.unmodifiableList(reports); }
}
