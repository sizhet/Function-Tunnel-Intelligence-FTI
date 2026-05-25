package com.dbm.fti.drone.demo;

import com.dbm.fti.drone.model.DroneState;
import com.dbm.fti.drone.model.NavigationResult;
import com.dbm.fti.drone.model.TerrainTunnel;
import com.dbm.fti.drone.model.Waypoint;
import com.dbm.fti.drone.engine.*;
import com.dbm.fti.drone.printer.DroneNavigationPrinter;

public class DroneTunnelNavigationDemoMain {

    public static void main(String[] args) {

        Waypoint target =
                new Waypoint(100, 100);

        DroneState noisyDrone =
                new DroneState(94, 106);

        DriftSimulator driftSimulator =
                new DriftSimulator();

        noisyDrone.move(
                driftSimulator.generateDrift(6.0),
                driftSimulator.generateDrift(6.0));

        ExactNavigationEngine exactEngine =
                new ExactNavigationEngine();

        NavigationResult exactResult =
                exactEngine.navigate(
                        noisyDrone,
                        target,
                        2.0);

        TerrainTunnelEstimator estimator =
                new TerrainTunnelEstimator();

        TerrainTunnel tunnel =
                estimator.estimateTunnel();

        FunctionTunnelNavigationEngine tunnelEngine =
                new FunctionTunnelNavigationEngine();

        NavigationResult tunnelResult =
                tunnelEngine.navigate(
                        noisyDrone,
                        target,
                        tunnel);

        TunnelRecoveryEngine recoveryEngine =
                new TunnelRecoveryEngine();

        recoveryEngine.recover(
                noisyDrone,
                target);

        DroneNavigationPrinter printer =
                new DroneNavigationPrinter();

        printer.print(
                "Exact Linear Navigation",
                exactResult);

        printer.print(
                "Function-Tunnel Navigation",
                tunnelResult);

        System.out.println("--------------------------------");
        System.out.println("Recovered Drone Position: "
                + noisyDrone);
    }
}
/*
Expected Console Output
--------------------------------
Mode: Exact Linear Navigation
Result: FAILED: outside exact tolerance.
MISSION STATUS: FAILED

--------------------------------
Mode: Function-Tunnel Navigation
Result: INSIDE FUNCTION-TUNNEL.
MISSION STATUS: SURVIVED

--------------------------------
Recovered Drone Position:
(96.7, 102.1)
 */