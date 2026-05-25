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