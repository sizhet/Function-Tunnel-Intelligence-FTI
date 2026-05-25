package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.DroneState;
import com.dbm.fti.drone.model.NavigationResult;
import com.dbm.fti.drone.model.Waypoint;

public class ExactNavigationEngine {

    public NavigationResult navigate(
            DroneState drone,
            Waypoint target,
            double tolerance) {

        double distance =
                drone.distanceTo(target);

        if (distance <= tolerance) {

            return new NavigationResult(
                    true,
                    "Exact waypoint reached.");
        }

        return new NavigationResult(
                false,
                "FAILED: outside exact tolerance.");
    }
}