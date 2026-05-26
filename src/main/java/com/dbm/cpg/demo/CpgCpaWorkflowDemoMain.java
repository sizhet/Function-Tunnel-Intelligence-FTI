package com.dbm.cpg.demo;

import com.dbm.cpg.model.CpgCpaResult;
import com.dbm.cpg.trace.MarkdownTracePrinter;

public final class CpgCpaWorkflowDemoMain {
    public static void main(String[] args) {
        CpgCpaResult result = new DistributedPlannerDerivationDemo().run();
        System.out.println(new MarkdownTracePrinter().print(result));
    }
}
