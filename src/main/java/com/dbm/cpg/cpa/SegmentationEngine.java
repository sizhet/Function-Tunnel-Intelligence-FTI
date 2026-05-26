package com.dbm.cpg.cpa;

import com.dbm.cpg.model.StructuralGraph;
import com.dbm.cpg.model.StructuralNode;
import java.util.*;

public final class SegmentationEngine {
    public List<String> segmentRoles(StructuralGraph graph) {
        List<String> roles = new ArrayList<String>();
        for (StructuralNode node : graph.getNodes()) roles.add(node.getRole());
        return roles;
    }
}
