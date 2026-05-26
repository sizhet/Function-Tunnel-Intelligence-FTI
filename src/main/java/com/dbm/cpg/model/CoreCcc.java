package com.dbm.cpg.model;

import java.util.*;

public final class CoreCcc {
    private final List<String> roles;

    public CoreCcc(List<String> roles) { this.roles = new ArrayList<String>(roles); }
    public List<String> getRoles() { return Collections.unmodifiableList(roles); }

    public boolean contains(String role) { return roles.contains(role); }

    public double overlap(CoreCcc other) {
        if (roles.isEmpty()) return 1.0;
        int hit = 0;
        for (String r : roles) if (other.roles.contains(r)) hit++;
        return ((double) hit) / roles.size();
    }

    @Override public String toString() { return roles.toString(); }
}
