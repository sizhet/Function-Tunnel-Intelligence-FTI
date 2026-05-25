package com.dbm.fti.elasticir.engine;

import com.dbm.fti.elasticir.model.ElasticCurve;
import com.dbm.fti.elasticir.model.Point2D;

import java.util.Random;

public class ElasticCurveGenerator {

    private final Random random = new Random();

    public ElasticCurve generateBaseCurve() {

        ElasticCurve curve = new ElasticCurve("BaseCurve");

        for (int x = 0; x < 20; x++) {
            double y = Math.sin(x * 0.3);
            curve.addPoint(new Point2D(x, y));
        }

        return curve;
    }

    public ElasticCurve generateNoisyVariant(
            String name,
            ElasticCurve base,
            double noiseScale) {

        ElasticCurve curve = new ElasticCurve(name);

        for (Point2D p : base.getPoints()) {

            double nx = p.getX();
            double ny = p.getY() +
                    ((random.nextDouble() - 0.5) * noiseScale);

            curve.addPoint(new Point2D(nx, ny));
        }

        return curve;
    }
}