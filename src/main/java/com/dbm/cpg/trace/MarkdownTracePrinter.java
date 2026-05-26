package com.dbm.cpg.trace;

import com.dbm.cpg.model.*;

public final class MarkdownTracePrinter {
    public String print(CpgCpaResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append("# CPG-CPA Preservation Trace\n\n");
        sb.append("## Source Graph\n\n").append(result.getSourceAnalysis().getGraph().getName()).append("\n\n");
        sb.append("## CPA Result\n\n");
        sb.append("Core CCC: `").append(result.getSourceAnalysis().getCoreCcc()).append("`\n\n");
        sb.append("Policy CCC: `").append(result.getSourceAnalysis().getPolicyCcc()).append("`\n\n");
        sb.append("---\n\n");
        sb.append("## Candidate Reports\n\n");
        for (PreservationReport r : result.getReports()) {
            sb.append("### ").append(r.getCandidate().getName()).append("\n\n");
            sb.append("Candidate Graph: `").append(r.getCandidate().getGraph().getName()).append("`\n\n");
            sb.append("Changes:\n");
            for (String c : r.getCandidate().getChanges()) sb.append("- ").append(c).append("\n");
            sb.append("\nRecovered Core CCC: `").append(r.getCandidateAnalysis().getCoreCcc()).append("`\n\n");
            sb.append("Recovered Policy CCC: `").append(r.getCandidateAnalysis().getPolicyCcc()).append("`\n\n");
            sb.append("Core Score: `").append(r.getCoreScore()).append("`\n\n");
            sb.append("Policy Score: `").append(r.getPolicyScore()).append("`\n\n");
            sb.append("Decision: **").append(r.getDecision()).append("**\n\n");
            sb.append("Notes:\n");
            for (String n : r.getNotes()) sb.append("- ").append(n).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }
}
