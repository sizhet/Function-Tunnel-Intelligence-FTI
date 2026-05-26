package com.dbm.cpg;

import com.dbm.cpg.demo.DistributedPlannerDerivationDemo;
import com.dbm.cpg.model.CpgCpaResult;
import com.dbm.cpg.trace.MarkdownTracePrinter;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkflowDemoTest {
    @Test public void printsMarkdownTrace() {
        CpgCpaResult result = new DistributedPlannerDerivationDemo().run();
        String md = new MarkdownTracePrinter().print(result);
        assertTrue(md.contains("CPG-CPA Preservation Trace"));
        assertTrue(md.contains("Core CCC"));
        assertTrue(md.contains("Decision"));
    }
}
