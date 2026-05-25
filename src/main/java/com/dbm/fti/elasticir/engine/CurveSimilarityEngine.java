package com.dbm.fti.elasticir.engine;

import com.dbm.fti.elasticir.model.ElasticCurve;
import com.dbm.fti.elasticir.model.Point2D;

import java.util.List;

public class CurveSimilarityEngine {

    public double computeSimilarity(ElasticCurve a, ElasticCurve b) {

        List<Point2D> pa = a.getPoints();
        List<Point2D> pb = b.getPoints();

        int size = Math.min(pa.size(), pb.size());

        double totalDistance = 0.0;

        for (int i = 0; i < size; i++) {
            totalDistance += pa.get(i).distance(pb.get(i));
        }

        double avgDistance = totalDistance / size;

        return 1.0 / (1.0 + avgDistance);
    }
}