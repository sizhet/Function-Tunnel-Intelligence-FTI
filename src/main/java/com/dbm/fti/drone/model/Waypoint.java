package com.dbm.fti.drone.model;

public class Waypoint {

    private final double x;
    private final double y;

    public Waypoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}