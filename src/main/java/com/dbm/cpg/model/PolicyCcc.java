package com.dbm.cpg.model;

import java.util.*;

public final class PolicyCcc {
    private final Set<String> policies;

    public PolicyCcc(Collection<String> policies) { this.policies = new LinkedHashSet<String>(policies); }
    public Set<String> getPolicies() { return Collections.unmodifiableSet(policies); }
    public boolean contains(String policy) { return policies.contains(policy); }

    public double overlap(PolicyCcc other) {
        if (policies.isEmpty()) return 1.0;
        int hit = 0;
        for (String p : policies) if (other.policies.contains(p)) hit++;
        return ((double) hit) / policies.size();
    }

    @Override public String toString() { return policies.toString(); }
}
