package com.dbm.fti.drone.model;

public class DroneState {

    private double x;
    private double y;

    public DroneState(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Waypoint waypoint) {

        double dx = x - waypoint.getX();
        double dy = y - waypoint.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}