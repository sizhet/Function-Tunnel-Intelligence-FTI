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