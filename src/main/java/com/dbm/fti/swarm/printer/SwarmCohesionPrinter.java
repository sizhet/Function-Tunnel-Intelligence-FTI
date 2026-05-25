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