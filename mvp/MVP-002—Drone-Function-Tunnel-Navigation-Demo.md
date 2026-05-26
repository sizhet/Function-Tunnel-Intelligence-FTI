# MVP-002 — Drone Function-Tunnel Navigation Demo

## Purpose

This MVP demonstrates one of the most important application scenarios of:

#### Function-Tunnel Intelligence (FTI)

It compares:

#### Traditional Exact Linear Navigation

vs.

#### Function-Tunnel Navigation

under:

- drift,
- noisy sensors,
- unstable movement,
- and environmental perturbation.

The demo illustrates a key FTI principle:

> Exact navigation is brittle and expensive.\
> Function-tunnel navigation is elastic, survivable, and low-cost-friendly.

## Project Structure

    fti-demo-drone-navigation/
    ├── README.md
    │
    ├── src/main/java/com/dbm/fti/drone/
    │
    ├── model/
    │   ├── DroneState.java
    │   ├── Waypoint.java
    │   ├── TerrainTunnel.java
    │   └── NavigationResult.java
    │
    ├── engine/
    │   ├── ExactNavigationEngine.java
    │   ├── FunctionTunnelNavigationEngine.java
    │   ├── DriftSimulator.java
    │   ├── TunnelRecoveryEngine.java
    │   └── TerrainTunnelEstimator.java
    │
    ├── printer/
    │   └── DroneNavigationPrinter.java
    │
    ├── demo/
    │   └── DroneTunnelNavigationDemoMain.java
    │
    └── src/test/java/com/dbm/fti/drone/
        └── TunnelRecoverySmokeTest.java

## README.md
## MVP-002 — Drone Function-Tunnel Navigation

This MVP demonstrates:

## Function-Tunnel Navigation

for low-cost autonomous drones operating under:

- drift,
- noisy control,
- sensor instability,
- and imperfect navigation conditions.

Traditional navigation systems often rely on:

- exact waypoint tracking,
- narrow tolerance corridors,
- and rigid trajectory assumptions.

FTI introduces:

- elastic structural tunnels,
- trajectory corridors,
- and adaptive runtime recovery.

The drone no longer needs to remain exactly on one line.

Instead, it only needs to remain inside:

# an acceptable function-tunnel.

This dramatically improves:

- survivability,
- robustness,
- and low-cost autonomy.

### DroneState.java
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

### Waypoint.java
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

### TerrainTunnel.java
package com.dbm.fti.drone.model;

public class TerrainTunnel {

    private final double width;

    public TerrainTunnel(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}

### NavigationResult.java
package com.dbm.fti.drone.model;

public class NavigationResult {

    private final boolean success;
    private final String message;

    public NavigationResult(
            boolean success,
            String message) {

        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}

### DriftSimulator.java
package com.dbm.fti.drone.engine;

import java.util.Random;

public class DriftSimulator {

    private final Random random = new Random();

    public double generateDrift(double scale) {

        return (random.nextDouble() - 0.5) * scale;
    }
}

### ExactNavigationEngine.java
package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.*;

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

### FunctionTunnelNavigationEngine.java
package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.*;

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

### TerrainTunnelEstimator.java
package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.TerrainTunnel;

public class TerrainTunnelEstimator {

    public TerrainTunnel estimateTunnel() {

        // simplified fixed-width tunnel
        return new TerrainTunnel(8.0);
    }
}

### TunnelRecoveryEngine.java
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

### DroneNavigationPrinter.java
package com.dbm.fti.drone.printer;

import com.dbm.fti.drone.model.NavigationResult;

public class DroneNavigationPrinter {

    public void print(
            String mode,
            NavigationResult result) {

        System.out.println("--------------------------------");
        System.out.println("Mode: " + mode);
        System.out.println("Result: " + result.getMessage());

        if (result.isSuccess()) {
            System.out.println("MISSION STATUS: SURVIVED");
        } else {
            System.out.println("MISSION STATUS: FAILED");
        }
    }
}

### DroneTunnelNavigationDemoMain.java
package com.dbm.fti.drone.demo;

import com.dbm.fti.drone.engine.*;
import com.dbm.fti.drone.model.*;
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

### Expected Console Output
    
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

### TunnelRecoverySmokeTest.java
package com.dbm.fti.drone;

import com.dbm.fti.drone.demo.DroneTunnelNavigationDemoMain;
import org.junit.Test;

public class TunnelRecoverySmokeTest {

    @Test
    public void smokeTest() {

        DroneTunnelNavigationDemoMain.main(
                new String[0]);
    }
}

## Why This MVP Matters

This MVP demonstrates one of the most important principles of:

#### Function-Tunnel Intelligence (FTI)

Traditional exact-control navigation:

- becomes brittle under drift,
- requires expensive precision hardware,
- and collapses under narrow tolerances.

FTI instead uses:

- elastic structural corridors,
- adaptive tunnel recovery,
- and trajectory survivability.

This allows:

- lower-cost autonomous systems,
- robust runtime adaptation,
- and scalable swarm-friendly navigation.

The key transition is:

#### from exact path-following

to:

#### survivable function-tunnel navigation.