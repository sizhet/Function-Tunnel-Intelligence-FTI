package com.dbm.fti.swarm.model;

public class SwarmTunnel {

    private final double centerX;
    private final double centerY;
    private final double radius;

    public SwarmTunnel(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }
}