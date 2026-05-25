# MVP-003 — Swarm Tunnel Cohesion Demo

## Purpose

Demonstrate FTI for swarm systems:

Agents do not need exact synchronization or identical paths.
They only need to remain inside the same structural function-tunnel.

Project Structure
fti-demo-swarm-cohesion/
├── README.md
├── src/main/java/com/dbm/fti/swarm/
│   ├── model/
│   │   ├── AgentState.java
│   │   ├── SwarmTunnel.java
│   │   └── CohesionResult.java
│   ├── engine/
│   │   ├── SwarmGenerator.java
│   │   ├── SwarmCohesionEngine.java
│   │   ├── SwarmTunnelEstimator.java
│   │   └── SwarmCorrectionEngine.java
│   ├── printer/
│   │   └── SwarmCohesionPrinter.java
│   └── demo/
│       └── SwarmTunnelCohesionDemoMain.java
└── src/test/java/com/dbm/fti/swarm/
    └── SwarmCohesionSmokeTest.java
README.md
# MVP-003 — Swarm Tunnel Cohesion Demo

This demo shows how Function-Tunnel Intelligence supports swarm systems.

Traditional swarm control often assumes:

- tight synchronization,
- exact formation geometry,
- rigid relative positioning.

FTI instead allows:

- local drift,
- individual variation,
- decentralized deviation,
- structural corridor cohesion.

The swarm does not need to follow one exact formation line.

It only needs to remain inside a shared:

# function-tunnel.

This MVP demonstrates:

- swarm state generation,
- tunnel width estimation,
- cohesion scoring,
- inside/outside tunnel judgment,
- simple correction toward tunnel center.
AgentState.java
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
SwarmTunnel.java
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
CohesionResult.java
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
SwarmGenerator.java
package com.dbm.fti.swarm.engine;

import com.dbm.fti.swarm.model.AgentState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SwarmGenerator {

    private final Random random = new Random(7);

    public List<AgentState> generateSwarm(
            int count,
            double centerX,
            double centerY,
            double noiseScale) {

        List<AgentState> agents = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double x = centerX + (random.nextDouble() - 0.5) * noiseScale;
            double y = centerY + (random.nextDouble() - 0.5) * noiseScale;

            agents.add(new AgentState("agent-" + i, x, y));
        }

        return agents;
    }
}
SwarmTunnelEstimator.java
package com.dbm.fti.swarm.engine;

import com.dbm.fti.swarm.model.SwarmTunnel;

public class SwarmTunnelEstimator {

    public SwarmTunnel estimateTunnel() {
        return new SwarmTunnel(50.0, 50.0, 12.0);
    }
}
SwarmCohesionEngine.java
package com.dbm.fti.swarm.engine;

import com.dbm.fti.swarm.model.AgentState;
import com.dbm.fti.swarm.model.CohesionResult;
import com.dbm.fti.swarm.model.SwarmTunnel;

import java.util.List;

public class SwarmCohesionEngine {

    public CohesionResult evaluate(
            List<AgentState> agents,
            SwarmTunnel tunnel,
            double requiredInsideRatio) {

        int inside = 0;

        for (AgentState agent : agents) {
            double d = agent.distanceTo(
                    tunnel.getCenterX(),
                    tunnel.getCenterY());

            if (d <= tunnel.getRadius()) {
                inside++;
            }
        }

        double score = inside / (double) agents.size();
        boolean accepted = score >= requiredInsideRatio;

        return new CohesionResult(
                agents.size(),
                inside,
                score,
                accepted);
    }
}
SwarmCorrectionEngine.java
package com.dbm.fti.swarm.engine;

import com.dbm.fti.swarm.model.AgentState;
import com.dbm.fti.swarm.model.SwarmTunnel;

import java.util.List;

public class SwarmCorrectionEngine {

    public void correctTowardTunnel(
            List<AgentState> agents,
            SwarmTunnel tunnel,
            double correctionRate) {

        for (AgentState agent : agents) {

            double dx = tunnel.getCenterX() - agent.getX();
            double dy = tunnel.getCenterY() - agent.getY();

            agent.move(
                    dx * correctionRate,
                    dy * correctionRate);
        }
    }
}
SwarmCohesionPrinter.java
package com.dbm.fti.swarm.printer;

import com.dbm.fti.swarm.model.AgentState;
import com.dbm.fti.swarm.model.CohesionResult;

import java.util.List;

public class SwarmCohesionPrinter {

    public void printAgents(List<AgentState> agents) {

        System.out.println("Agents:");
        for (AgentState agent : agents) {
            System.out.println(
                    agent.getId()
                            + " -> ("
                            + round(agent.getX())
                            + ", "
                            + round(agent.getY())
                            + ")");
        }
    }

    public void printResult(String title, CohesionResult result) {

        System.out.println("--------------------------------");
        System.out.println(title);
        System.out.println("Inside agents: "
                + result.getInsideAgents()
                + "/"
                + result.getTotalAgents());
        System.out.println("Cohesion score: "
                + round(result.getCohesionScore()));

        if (result.isSwarmInsideTunnel()) {
            System.out.println("SWARM STATUS: INSIDE FUNCTION-TUNNEL");
        } else {
            System.out.println("SWARM STATUS: OUTSIDE FUNCTION-TUNNEL");
        }
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
SwarmTunnelCohesionDemoMain.java
package com.dbm.fti.swarm.demo;

import com.dbm.fti.swarm.engine.*;
import com.dbm.fti.swarm.model.*;
import com.dbm.fti.swarm.printer.SwarmCohesionPrinter;

import java.util.List;

public class SwarmTunnelCohesionDemoMain {

    public static void main(String[] args) {

        SwarmGenerator generator = new SwarmGenerator();
        SwarmTunnelEstimator estimator = new SwarmTunnelEstimator();
        SwarmCohesionEngine cohesionEngine = new SwarmCohesionEngine();
        SwarmCorrectionEngine correctionEngine = new SwarmCorrectionEngine();
        SwarmCohesionPrinter printer = new SwarmCohesionPrinter();

        SwarmTunnel tunnel = estimator.estimateTunnel();

        List<AgentState> swarm = generator.generateSwarm(
                10,
                50.0,
                50.0,
                32.0);

        CohesionResult before = cohesionEngine.evaluate(
                swarm,
                tunnel,
                0.70);

        printer.printAgents(swarm);
        printer.printResult("Before Tunnel Correction", before);

        correctionEngine.correctTowardTunnel(
                swarm,
                tunnel,
                0.35);

        CohesionResult after = cohesionEngine.evaluate(
                swarm,
                tunnel,
                0.70);

        printer.printAgents(swarm);
        printer.printResult("After Tunnel Correction", after);
    }
}
Expected Console Output
Agents:
agent-0 -> (57.39, 42.15)
agent-1 -> (37.13, 46.59)
...

--------------------------------
Before Tunnel Correction
Inside agents: 6/10
Cohesion score: 0.6
SWARM STATUS: OUTSIDE FUNCTION-TUNNEL

Agents:
agent-0 -> (54.8, 44.9)
agent-1 -> (41.63, 47.78)
...

--------------------------------
After Tunnel Correction
Inside agents: 9/10
Cohesion score: 0.9
SWARM STATUS: INSIDE FUNCTION-TUNNEL
SwarmCohesionSmokeTest.java
package com.dbm.fti.swarm;

import com.dbm.fti.swarm.demo.SwarmTunnelCohesionDemoMain;
import org.junit.Test;

public class SwarmCohesionSmokeTest {

    @Test
    public void smokeTest() {
        SwarmTunnelCohesionDemoMain.main(new String[0]);
    }
}
Why This MVP Matters

MVP-003 shows that FTI naturally extends from single-agent navigation to swarm-level coordination.

The key transition is:

Exact formation control
        ↓
Function-tunnel cohesion

The swarm does not need:

identical paths,
rigid formation,
perfect synchronization.

It needs:

shared structural direction,
sufficient tunnel membership,
recoverable deviation,
and cohesion inside an acceptable behavioral manifold.

This is a clean bridge from FTI to:

swarm robotics,
low-cost drone fleets,
decentralized agents,
industrial multi-robot systems,
and collective runtime intelligence.