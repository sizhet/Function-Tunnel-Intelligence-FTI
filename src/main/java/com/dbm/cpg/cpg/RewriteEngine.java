package com.dbm.cpg.cpg;

import com.dbm.cpg.model.*;
import java.util.*;

public final class RewriteEngine {
    public List<String> suggest(PreservationReport report) {
        List<String> suggestions = new ArrayList<String>();
        if (report.getCoreScore() < 1.0) suggestions.add("Recover missing Core CCC role(s).");
        if (report.getPolicyScore() < 1.0) suggestions.add("Rewrite candidate toward preserved policy CCC.");
        if (suggestions.isEmpty()) suggestions.add("No rewrite required.");
        return suggestions;
    }
}
