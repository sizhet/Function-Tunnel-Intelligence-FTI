package com.dbm.fti.elasticir.printer;

import com.dbm.fti.elasticir.model.MatchResult;

public class TunnelVisualizationPrinter {

    public void print(
            String name,
            MatchResult result) {

        System.out.println("----------------------------------");
        System.out.println("Trajectory: " + name);
        System.out.println("Similarity: " + result.getSimilarity());

        if (result.isInsideTunnel()) {
            System.out.println("Status: INSIDE FUNCTION-TUNNEL");
        } else {
            System.out.println("Status: OUTSIDE FUNCTION-TUNNEL");
        }
    }
}