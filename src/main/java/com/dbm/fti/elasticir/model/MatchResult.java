package com.dbm.fti.elasticir.model;

public class MatchResult {

    private final double similarity;
    private final boolean insideTunnel;

    public MatchResult(double similarity, boolean insideTunnel) {
        this.similarity = similarity;
        this.insideTunnel = insideTunnel;
    }

    public double getSimilarity() {
        return similarity;
    }

    public boolean isInsideTunnel() {
        return insideTunnel;
    }
}