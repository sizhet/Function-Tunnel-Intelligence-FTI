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
/*
Expected Console Output
----------------------------------
Trajectory: MildNoise
Similarity: 0.89
Status: INSIDE FUNCTION-TUNNEL

----------------------------------
Trajectory: StrongNoise
Similarity: 0.43
Status: OUTSIDE FUNCTION-TUNNEL
 */