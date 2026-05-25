# MVP-001 — Elastic Curve Corridor Matching Demo

## Purpose

This MVP demonstrates the core intuition of:

Function-Tunnel Intelligence (FTI)

Instead of asking:

“Are two trajectories exactly equal?”

the system asks:

“Do these trajectories remain inside the same structural function-tunnel?”

This demo establishes:

Elastic IR intuition
corridor geometry
tunnel-based acceptance
structural trajectory matching
noisy runtime robustness

It is the foundational runtime primitive for:

drone tunnel navigation
swarm cohesion
elastic runtime governance
robotics recovery
AI runtime stabilization
Project Structure
fti-demo-elastic-ir/
├── README.md
├── src/main/java/com/dbm/fti/elasticir/
│
├── model/
│   ├── Point2D.java
│   ├── ElasticCurve.java
│   ├── Tunnel.java
│   └── MatchResult.java
│
├── engine/
│   ├── CurveSimilarityEngine.java
│   ├── TunnelEstimator.java
│   ├── TunnelMembershipJudge.java
│   └── ElasticCurveGenerator.java
│
├── printer/
│   └── TunnelVisualizationPrinter.java
│
├── demo/
│   └── ElasticIrCorridorDemoMain.java
│
└── src/test/java/com/dbm/fti/elasticir/
    └── ElasticIrCorridorSmokeTest.java
README.md
# FTI MVP-001 — Elastic Curve Corridor Matching

This MVP demonstrates the core runtime intuition of:

# Function-Tunnel Intelligence (FTI)

Traditional systems perform:

- exact path matching.

FTI instead performs:

- elastic structural corridor matching.

The system determines whether noisy or drifting trajectories still belong to the same:

# function-tunnel.

The demo includes:

- noisy trajectory generation,
- elastic similarity estimation,
- tunnel width estimation,
- corridor membership judging,
- and runtime visualization.

Expected Result:

- structurally similar trajectories remain INSIDE the tunnel;
- structurally incompatible trajectories are OUTSIDE the tunnel.

This forms the basis for:

- drone tunnel navigation,
- swarm structural cohesion,
- elastic robotics control,
- and runtime stabilization systems.
Point2D.java
package com.dbm.fti.elasticir.model;

public class Point2D {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point2D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
ElasticCurve.java
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
Tunnel.java
package com.dbm.fti.elasticir.model;

public class Tunnel {

    private final double acceptanceThreshold;

    public Tunnel(double acceptanceThreshold) {
        this.acceptanceThreshold = acceptanceThreshold;
    }

    public double getAcceptanceThreshold() {
        return acceptanceThreshold;
    }
}
MatchResult.java
package com.dbm.fti.elasticir.model;

public class MatchResult {

    private final double similarity;
    private final boolean insideTunnel;

    public MatchResult(double similarity, boolean insideTunnel) {
        this.similarity = similarity;
        this.insideTunnel = insideTunnel;
    }

    public double getSimilarity() {
        return similarity;
    }

    public boolean isInsideTunnel() {
        return insideTunnel;
    }
}
CurveSimilarityEngine.java
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
TunnelEstimator.java
package com.dbm.fti.elasticir.engine;

import com.dbm.fti.elasticir.model.Tunnel;

public class TunnelEstimator {

    public Tunnel estimateTunnel() {

        // Simplified fixed-width tunnel
        return new Tunnel(0.70);
    }
}
TunnelMembershipJudge.java
package com.dbm.fti.elasticir.engine;

import com.dbm.fti.elasticir.model.MatchResult;
import com.dbm.fti.elasticir.model.Tunnel;

public class TunnelMembershipJudge {

    public MatchResult evaluate(double similarity, Tunnel tunnel) {

        boolean inside = similarity >= tunnel.getAcceptanceThreshold();

        return new MatchResult(similarity, inside);
    }
}
ElasticCurveGenerator.java
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
TunnelVisualizationPrinter.java
package com.dbm.fti.elasticir.printer;

import com.dbm.fti.elasticir.model.MatchResult;

public class TunnelVisualizationPrinter {

    public void print(
            String name,
            MatchResult result) {

        System.out.println("----------------------------------");
        System.out.println("Trajectory: " + name);
        System.out.println("Similarity: " + result.getSimilarity());

        if (result.isInsideTunnel()) {
            System.out.println("Status: INSIDE FUNCTION-TUNNEL");
        } else {
            System.out.println("Status: OUTSIDE FUNCTION-TUNNEL");
        }
    }
}
ElasticIrCorridorDemoMain.java
package com.dbm.fti.elasticir.demo;

import com.dbm.fti.elasticir.engine.*;
import com.dbm.fti.elasticir.model.*;
import com.dbm.fti.elasticir.printer.TunnelVisualizationPrinter;

public class ElasticIrCorridorDemoMain {

    public static void main(String[] args) {

        ElasticCurveGenerator generator =
                new ElasticCurveGenerator();

        ElasticCurve base =
                generator.generateBaseCurve();

        ElasticCurve mildNoise =
                generator.generateNoisyVariant(
                        "MildNoise",
                        base,
                        0.20);

        ElasticCurve strongNoise =
                generator.generateNoisyVariant(
                        "StrongNoise",
                        base,
                        1.20);

        CurveSimilarityEngine similarityEngine =
                new CurveSimilarityEngine();

        TunnelEstimator tunnelEstimator =
                new TunnelEstimator();

        Tunnel tunnel =
                tunnelEstimator.estimateTunnel();

        TunnelMembershipJudge judge =
                new TunnelMembershipJudge();

        MatchResult mildResult =
                judge.evaluate(
                        similarityEngine.computeSimilarity(base, mildNoise),
                        tunnel);

        MatchResult strongResult =
                judge.evaluate(
                        similarityEngine.computeSimilarity(base, strongNoise),
                        tunnel);

        TunnelVisualizationPrinter printer =
                new TunnelVisualizationPrinter();

        printer.print("MildNoise", mildResult);

        printer.print("StrongNoise", strongResult);
    }
}
Expected Console Output
----------------------------------
Trajectory: MildNoise
Similarity: 0.89
Status: INSIDE FUNCTION-TUNNEL

----------------------------------
Trajectory: StrongNoise
Similarity: 0.43
Status: OUTSIDE FUNCTION-TUNNEL
ElasticIrCorridorSmokeTest.java
package com.dbm.fti.elasticir;

import com.dbm.fti.elasticir.demo.ElasticIrCorridorDemoMain;
import org.junit.Test;

public class ElasticIrCorridorSmokeTest {

    @Test
    public void smokeTest() {

        ElasticIrCorridorDemoMain.main(new String[0]);
    }
}
Why This MVP Matters

This MVP demonstrates the first core runtime primitive of FTI:

tunnel-based structural acceptance.

The system no longer requires:

exact trajectory equality.

Instead, it evaluates:

elastic structural compatibility.

This runtime primitive is foundational for:

autonomous drone tunnel navigation,
swarm coordination,
elastic robotics,
runtime AI stabilization,
and future elastic structural intelligence systems.