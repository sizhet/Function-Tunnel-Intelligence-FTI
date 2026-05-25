package com.dbm.fti.elasticir.model;

public class Tunnel {

    private final double acceptanceThreshold;

    public Tunnel(double acceptanceThreshold) {
        this.acceptanceThreshold = acceptanceThreshold;
    }

    public double getAcceptanceThreshold() {
        return acceptanceThreshold;
    }
}