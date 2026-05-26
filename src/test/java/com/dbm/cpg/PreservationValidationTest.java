package com.dbm.cpg;

import com.dbm.cpg.demo.PlannerGraphDemo;
import com.dbm.cpg.model.*;
import com.dbm.cpg.runtime.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PreservationValidationTest {
    @Test public void detectsAcceptRewriteAndRejectOrRewriteCases() {
        CpgCpaResult result = new DefaultCpgCpaRuntime().run(PlannerGraphDemo.plannerGraph(), new RuntimeContext("safe"));
        boolean hasAccept = false;
        boolean hasRewrite = false;
        for (PreservationReport report : result.getReports()) {
            if (report.getDecision() == RewriteDecision.ACCEPT) hasAccept = true;
            if (report.getDecision() == RewriteDecision.REWRITE) hasRewrite = true;
        }
        assertTrue(hasAccept);
        assertTrue(hasRewrite);
    }
}
