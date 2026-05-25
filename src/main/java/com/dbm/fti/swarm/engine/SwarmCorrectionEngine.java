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