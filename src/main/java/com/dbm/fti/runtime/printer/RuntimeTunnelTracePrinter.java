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