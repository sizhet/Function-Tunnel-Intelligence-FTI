package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.ReasoningStep;
import com.dbm.fti.runtime.model.RuntimeTrace;

public class ReasoningDriftSimulator {

    public RuntimeTrace generateTrace() {

        RuntimeTrace trace = new RuntimeTrace();

        trace.addStep(new ReasoningStep(
                "S1",
                "The system starts from a grounded user request.",
                0.90,
                0.92,
                0.88));

        trace.addStep(new ReasoningStep(
                "S2",
                "The reasoning expands into a useful structural interpretation.",
                0.82,
                0.86,
                0.91));

        trace.addStep(new ReasoningStep(
                "S3",
                "The reasoning begins to overclaim beyond available support.",
                0.42,
                0.70,
                0.76));

        trace.addStep(new ReasoningStep(
                "S4",
                "The reasoning returns to a bounded, policy-aware formulation.",
                0.78,
                0.88,
                0.84));

        return trace;
    }
}