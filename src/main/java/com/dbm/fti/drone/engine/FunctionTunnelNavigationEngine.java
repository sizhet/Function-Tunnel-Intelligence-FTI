package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.DroneState;
import com.dbm.fti.drone.model.NavigationResult;
import com.dbm.fti.drone.model.TerrainTunnel;
import com.dbm.fti.drone.model.Waypoint;

public class FunctionTunnelNavigationEngine {

    public NavigationResult navigate(
            DroneState drone,
            Waypoint target,
            TerrainTunnel tunnel) {

        double distance =
                drone.distanceTo(target);

        if (distance <= tunnel.getWidth()) {

            return new NavigationResult(
                    true,
                    "INSIDE FUNCTION-TUNNEL.");
        }

        return new NavigationResult(
                false,
                "OUTSIDE FUNCTION-TUNNEL.");
    }
}