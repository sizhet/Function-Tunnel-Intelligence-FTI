package com.dbm.cpg;

import com.dbm.cpg.cpa.CpaEngine;
import com.dbm.cpg.demo.PlannerGraphDemo;
import com.dbm.cpg.model.CpaResult;
import org.junit.Test;
import static org.junit.Assert.*;

public class CpaEngineSmokeTest {
    @Test public void extractsCoreAndPolicyCcc() {
        CpaResult result = new CpaEngine().analyze(PlannerGraphDemo.plannerGraph());
        assertTrue(result.getCoreCcc().contains("PLAN"));
        assertTrue(result.getCoreCcc().contains("VALIDATE"));
        assertTrue(result.getCoreCcc().contains("EXECUTE"));
        assertTrue(result.getCoreCcc().contains("TRACE"));
        assertTrue(result.getPolicyCcc().contains("VALIDATION_REQUIRED"));
        assertTrue(result.getPolicyCcc().contains("TRACE_REQUIRED"));
        assertTrue(result.getPolicyCcc().contains("VALIDATE_BEFORE_EXECUTE"));
    }
}
