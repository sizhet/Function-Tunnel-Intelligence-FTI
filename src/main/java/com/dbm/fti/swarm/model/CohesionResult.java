package com.dbm.fti.swarm.model;

public class CohesionResult {

    private final int totalAgents;
    private final int insideAgents;
    private final double cohesionScore;
    private final boolean swarmInsideTunnel;

    public CohesionResult(
            int totalAgents,
            int insideAgents,
            double cohesionScore,
            boolean swarmInsideTunnel) {

        this.totalAgents = totalAgents;
        this.insideAgents = insideAgents;
        this.cohesionScore = cohesionScore;
        this.swarmInsideTunnel = swarmInsideTunnel;
    }

    public int getTotalAgents() {
        return totalAgents;
    }

    public int getInsideAgents() {
        return insideAgents;
    }

    public double getCohesionScore() {
        return cohesionScore;
    }

    public boolean isSwarmInsideTunnel() {
        return swarmInsideTunnel;
    }
}