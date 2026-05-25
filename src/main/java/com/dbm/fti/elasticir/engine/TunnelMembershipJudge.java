package com.dbm.fti.elasticir.engine;

import com.dbm.fti.elasticir.model.MatchResult;
import com.dbm.fti.elasticir.model.Tunnel;

public class TunnelMembershipJudge {

    public MatchResult evaluate(double similarity, Tunnel tunnel) {

        boolean inside = similarity >= tunnel.getAcceptanceThreshold();

        return new MatchResult(similarity, inside);
    }
}