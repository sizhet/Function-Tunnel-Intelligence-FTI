package com.dbm.fti.drone.engine;

import java.util.Random;

public class DriftSimulator {

    private final Random random = new Random();

    public double generateDrift(double scale) {

        return (random.nextDouble() - 0.5) * scale;
    }
}