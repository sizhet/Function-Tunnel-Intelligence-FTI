package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.DroneState;
import com.dbm.fti.drone.model.Waypoint;

public class TunnelRecoveryEngine {

    public void recover(
            DroneState drone,
            Waypoint target) {

        double dx =
                (target.getX() - drone.getX()) * 0.2;

        double dy =
                (target.getY() - drone.getY()) * 0.2;

        drone.move(dx, dy);
    }
}