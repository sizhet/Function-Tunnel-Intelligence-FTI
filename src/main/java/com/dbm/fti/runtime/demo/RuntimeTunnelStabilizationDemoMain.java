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
/*
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
 */