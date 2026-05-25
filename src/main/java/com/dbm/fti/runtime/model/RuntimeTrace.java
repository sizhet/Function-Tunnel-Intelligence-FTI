package com.dbm.fti.runtime.model;

import java.util.ArrayList;
import java.util.List;

public class RuntimeTrace {

    private final List<ReasoningStep> steps = new ArrayList<>();

    public void addStep(ReasoningStep step) {
        steps.add(step);
    }

    public List<ReasoningStep> getSteps() {
        return steps;
    }
}