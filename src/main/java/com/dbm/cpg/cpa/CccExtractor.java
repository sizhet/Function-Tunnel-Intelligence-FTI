package com.dbm.cpg.cpa;

import com.dbm.cpg.model.CoreCcc;
import java.util.*;

public final class CccExtractor {
    private static final List<String> CANONICAL = Arrays.asList("PLAN", "VALIDATE", "EXECUTE", "TRACE");

    public CoreCcc extract(List<String> roles) {
        List<String> extracted = new ArrayList<String>();
        for (String role : CANONICAL) {
            if (roles.contains(role) || ("EXECUTE".equals(role) && roles.contains("WORKER_EXECUTE"))) extracted.add(role);
        }
        return new CoreCcc(extracted);
    }
}
