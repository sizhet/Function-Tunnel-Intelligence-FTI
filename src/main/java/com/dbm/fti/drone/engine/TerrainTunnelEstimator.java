package com.dbm.fti.drone.engine;

import com.dbm.fti.drone.model.TerrainTunnel;

public class TerrainTunnelEstimator {

    public TerrainTunnel estimateTunnel() {

        // simplified fixed-width tunnel
        return new TerrainTunnel(8.0);
    }
}