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
/*
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
 */