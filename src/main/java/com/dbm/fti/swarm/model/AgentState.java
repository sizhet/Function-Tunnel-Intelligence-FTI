package com.dbm.fti.swarm.model;

public class AgentState {

    private final String id;
    private double x;
    private double y;

    public AgentState(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(double tx, double ty) {
        double dx = x - tx;
        double dy = y - ty;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}