# MVP-004 — LLM Runtime Tunnel Stabilization Demo

## Purpose

Demonstrate FTI for AI runtime governance:

LLM reasoning does not need to follow one rigid token path.
It needs to remain inside an acceptable policy/function tunnel.

This MVP simulates:

reasoning drift,
hallucination risk,
policy deviation,
tunnel scoring,
runtime correction,
final stabilization.
Project Structure
fti-demo-runtime-stabilization/
├── README.md
├── src/main/java/com/dbm/fti/runtime/
│   ├── model/
│   │   ├── ReasoningStep.java
│   │   ├── PolicyTunnel.java
│   │   ├── RuntimeTrace.java
│   │   └── StabilizationResult.java
│   ├── engine/
│   │   ├── ReasoningDriftSimulator.java
│   │   ├── TunnelScoringEngine.java
│   │   ├── RuntimeCorrectionEngine.java
│   │   └── RuntimeTunnelController.java
│   ├── printer/
│   │   └── RuntimeTunnelTracePrinter.java
│   └── demo/
│       └── RuntimeTunnelStabilizationDemoMain.java
└── src/test/java/com/dbm/fti/runtime/
    └── RuntimeTunnelGovernanceSmokeTest.java
README.md
# MVP-004 — LLM Runtime Tunnel Stabilization Demo

This MVP demonstrates how Function-Tunnel Intelligence can support AI runtime governance.

Current LLM systems often produce reasoning trajectories that may drift through:

- hallucination,
- policy deviation,
- unsafe speculation,
- unsupported claims,
- or incoherent reasoning jumps.

FTI introduces the idea of a runtime policy/function tunnel.

The goal is not to force one exact reasoning path.

The goal is to keep reasoning inside an acceptable structural tunnel.

This demo simulates:

- reasoning steps,
- tunnel scoring,
- drift detection,
- runtime correction,
- final stabilized trace.

The key transition:

Exact answer checking
        ↓
Runtime tunnel stabilization
ReasoningStep.java
package com.dbm.fti.runtime.model;

public class ReasoningStep {

    private final String id;
    private final String content;
    private final double evidenceScore;
    private final double policyScore;
    private final double coherenceScore;

    public ReasoningStep(
            String id,
            String content,
            double evidenceScore,
            double policyScore,
            double coherenceScore) {

        this.id = id;
        this.content = content;
        this.evidenceScore = evidenceScore;
        this.policyScore = policyScore;
        this.coherenceScore = coherenceScore;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getEvidenceScore() {
        return evidenceScore;
    }

    public double getPolicyScore() {
        return policyScore;
    }

    public double getCoherenceScore() {
        return coherenceScore;
    }
}
PolicyTunnel.java
package com.dbm.fti.runtime.model;

public class PolicyTunnel {

    private final double minEvidenceScore;
    private final double minPolicyScore;
    private final double minCoherenceScore;
    private final double minCombinedScore;

    public PolicyTunnel(
            double minEvidenceScore,
            double minPolicyScore,
            double minCoherenceScore,
            double minCombinedScore) {

        this.minEvidenceScore = minEvidenceScore;
        this.minPolicyScore = minPolicyScore;
        this.minCoherenceScore = minCoherenceScore;
        this.minCombinedScore = minCombinedScore;
    }

    public double getMinEvidenceScore() {
        return minEvidenceScore;
    }

    public double getMinPolicyScore() {
        return minPolicyScore;
    }

    public double getMinCoherenceScore() {
        return minCoherenceScore;
    }

    public double getMinCombinedScore() {
        return minCombinedScore;
    }
}
RuntimeTrace.java
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
StabilizationResult.java
package com.dbm.fti.runtime.model;

public class StabilizationResult {

    private final ReasoningStep originalStep;
    private final ReasoningStep stabilizedStep;
    private final double combinedScoreBefore;
    private final double combinedScoreAfter;
    private final boolean insideTunnelBefore;
    private final boolean insideTunnelAfter;

    public StabilizationResult(
            ReasoningStep originalStep,
            ReasoningStep stabilizedStep,
            double combinedScoreBefore,
            double combinedScoreAfter,
            boolean insideTunnelBefore,
            boolean insideTunnelAfter) {

        this.originalStep = originalStep;
        this.stabilizedStep = stabilizedStep;
        this.combinedScoreBefore = combinedScoreBefore;
        this.combinedScoreAfter = combinedScoreAfter;
        this.insideTunnelBefore = insideTunnelBefore;
        this.insideTunnelAfter = insideTunnelAfter;
    }

    public ReasoningStep getOriginalStep() {
        return originalStep;
    }

    public ReasoningStep getStabilizedStep() {
        return stabilizedStep;
    }

    public double getCombinedScoreBefore() {
        return combinedScoreBefore;
    }

    public double getCombinedScoreAfter() {
        return combinedScoreAfter;
    }

    public boolean isInsideTunnelBefore() {
        return insideTunnelBefore;
    }

    public boolean isInsideTunnelAfter() {
        return insideTunnelAfter;
    }
}
ReasoningDriftSimulator.java
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
TunnelScoringEngine.java
package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.PolicyTunnel;
import com.dbm.fti.runtime.model.ReasoningStep;

public class TunnelScoringEngine {

    public double combinedScore(ReasoningStep step) {

        return (step.getEvidenceScore()
                + step.getPolicyScore()
                + step.getCoherenceScore()) / 3.0;
    }

    public boolean insideTunnel(
            ReasoningStep step,
            PolicyTunnel tunnel) {

        return step.getEvidenceScore() >= tunnel.getMinEvidenceScore()
                && step.getPolicyScore() >= tunnel.getMinPolicyScore()
                && step.getCoherenceScore() >= tunnel.getMinCoherenceScore()
                && combinedScore(step) >= tunnel.getMinCombinedScore();
    }
}
RuntimeCorrectionEngine.java
package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.ReasoningStep;

public class RuntimeCorrectionEngine {

    public ReasoningStep correct(ReasoningStep step) {

        return new ReasoningStep(
                step.getId() + "-corrected",
                "Corrected: keep the claim bounded, evidence-aware, and inside the policy tunnel.",
                Math.max(step.getEvidenceScore(), 0.76),
                Math.max(step.getPolicyScore(), 0.84),
                Math.max(step.getCoherenceScore(), 0.82));
    }
}
RuntimeTunnelController.java
package com.dbm.fti.runtime.engine;

import com.dbm.fti.runtime.model.*;

public class RuntimeTunnelController {

    private final TunnelScoringEngine scoringEngine =
            new TunnelScoringEngine();

    private final RuntimeCorrectionEngine correctionEngine =
            new RuntimeCorrectionEngine();

    public StabilizationResult stabilize(
            ReasoningStep step,
            PolicyTunnel tunnel) {

        double beforeScore =
                scoringEngine.combinedScore(step);

        boolean beforeInside =
                scoringEngine.insideTunnel(step, tunnel);

        ReasoningStep stabilizedStep = step;

        if (!beforeInside) {
            stabilizedStep =
                    correctionEngine.correct(step);
        }

        double afterScore =
                scoringEngine.combinedScore(stabilizedStep);

        boolean afterInside =
                scoringEngine.insideTunnel(
                        stabilizedStep,
                        tunnel);

        return new StabilizationResult(
                step,
                stabilizedStep,
                beforeScore,
                afterScore,
                beforeInside,
                afterInside);
    }
}
RuntimeTunnelTracePrinter.java
package com.dbm.fti.runtime.printer;

import com.dbm.fti.runtime.model.StabilizationResult;

public class RuntimeTunnelTracePrinter {

    public void print(StabilizationResult result) {

        System.out.println("--------------------------------");
        System.out.println("Original Step: "
                + result.getOriginalStep().getId());
        System.out.println("Original Content: "
                + result.getOriginalStep().getContent());
        System.out.println("Combined Score Before: "
                + round(result.getCombinedScoreBefore()));
        System.out.println("Inside Tunnel Before: "
                + result.isInsideTunnelBefore());

        if (!result.isInsideTunnelBefore()) {
            System.out.println("Correction Applied: YES");
            System.out.println("Stabilized Step: "
                    + result.getStabilizedStep().getId());
            System.out.println("Stabilized Content: "
                    + result.getStabilizedStep().getContent());
        } else {
            System.out.println("Correction Applied: NO");
        }

        System.out.println("Combined Score After: "
                + round(result.getCombinedScoreAfter()));
        System.out.println("Inside Tunnel After: "
                + result.isInsideTunnelAfter());
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
RuntimeTunnelStabilizationDemoMain.java
package com.dbm.fti.runtime.demo;

import com.dbm.fti.runtime.engine.ReasoningDriftSimulator;
import com.dbm.fti.runtime.engine.RuntimeTunnelController;
import com.dbm.fti.runtime.model.*;
import com.dbm.fti.runtime.printer.RuntimeTunnelTracePrinter;

public class RuntimeTunnelStabilizationDemoMain {

    public static void main(String[] args) {

        PolicyTunnel tunnel =
                new PolicyTunnel(
                        0.70,
                        0.80,
                        0.75,
                        0.78);

        ReasoningDriftSimulator simulator =
                new ReasoningDriftSimulator();

        RuntimeTrace trace =
                simulator.generateTrace();

        RuntimeTunnelController controller =
                new RuntimeTunnelController();

        RuntimeTunnelTracePrinter printer =
                new RuntimeTunnelTracePrinter();

        for (ReasoningStep step : trace.getSteps()) {

            StabilizationResult result =
                    controller.stabilize(
                            step,
                            tunnel);

            printer.print(result);
        }
    }
}
Expected Console Output
--------------------------------
Original Step: S1
Combined Score Before: 0.9
Inside Tunnel Before: true
Correction Applied: NO
Combined Score After: 0.9
Inside Tunnel After: true

--------------------------------
Original Step: S2
Combined Score Before: 0.86
Inside Tunnel Before: true
Correction Applied: NO
Combined Score After: 0.86
Inside Tunnel After: true

--------------------------------
Original Step: S3
Original Content: The reasoning begins to overclaim beyond available support.
Combined Score Before: 0.63
Inside Tunnel Before: false
Correction Applied: YES
Stabilized Step: S3-corrected
Stabilized Content: Corrected: keep the claim bounded, evidence-aware, and inside the policy tunnel.
Combined Score After: 0.81
Inside Tunnel After: true

--------------------------------
Original Step: S4
Combined Score Before: 0.83
Inside Tunnel Before: true
Correction Applied: NO
Combined Score After: 0.83
Inside Tunnel After: true
RuntimeTunnelGovernanceSmokeTest.java
package com.dbm.fti.runtime;

import com.dbm.fti.runtime.demo.RuntimeTunnelStabilizationDemoMain;
import org.junit.Test;

public class RuntimeTunnelGovernanceSmokeTest {

    @Test
    public void smokeTest() {
        RuntimeTunnelStabilizationDemoMain.main(new String[0]);
    }
}
Why This MVP Matters

MVP-004 connects FTI directly to AI runtime governance.

It demonstrates the transition from:

Static output checking
        ↓
Runtime reasoning tunnel stabilization

The key point:

LLM outputs should not merely be judged after generation.

They should be guided, corrected, and stabilized during runtime against an explicit policy/function tunnel.

This MVP provides a minimal skeleton for:

hallucination mitigation,
policy-aware reasoning,
runtime correction,
structural stabilization,
PDS-style governance,
post-LLM control-plane design.