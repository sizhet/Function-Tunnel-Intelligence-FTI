package com.dbm.fti.elasticir.model;

import java.util.ArrayList;
import java.util.List;

public class ElasticCurve {

    private final String name;
    private final List<Point2D> points = new ArrayList<>();

    public ElasticCurve(String name) {
        this.name = name;
    }

    public void addPoint(Point2D p) {
        points.add(p);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}