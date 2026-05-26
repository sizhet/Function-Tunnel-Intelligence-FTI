package com.dbm.cpg;

import com.dbm.cpg.demo.PlannerGraphDemo;
import com.dbm.cpg.model.*;
import com.dbm.cpg.runtime.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CpgEngineSmokeTest {
    @Test public void generatesCandidateReports() {
        CpgCpaResult result = new DefaultCpgCpaRuntime().run(PlannerGraphDemo.plannerGraph(), new RuntimeContext("safe"));
        assertEquals(3, result.getReports().size());
        assertEquals(RewriteDecision.ACCEPT, result.getReports().get(0).getDecision());
    }
}
