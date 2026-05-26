package com.dbm.cpg.demo;

import com.dbm.cpg.model.*;
import com.dbm.cpg.runtime.*;

public final class DistributedPlannerDerivationDemo {
    public CpgCpaResult run() {
        return new DefaultCpgCpaRuntime().run(PlannerGraphDemo.plannerGraph(), new RuntimeContext("safe"));
    }
}
