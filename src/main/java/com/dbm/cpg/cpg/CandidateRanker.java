package com.dbm.cpg.cpg;

import com.dbm.cpg.model.*;
import java.util.*;

public final class CandidateRanker {
    public List<PreservationReport> rank(List<PreservationReport> reports) {
        List<PreservationReport> copy = new ArrayList<PreservationReport>(reports);
        Collections.sort(copy, new Comparator<PreservationReport>() {
            public int compare(PreservationReport a, PreservationReport b) {
                return Double.compare(b.totalScore(), a.totalScore());
            }
        });
        return copy;
    }
}
