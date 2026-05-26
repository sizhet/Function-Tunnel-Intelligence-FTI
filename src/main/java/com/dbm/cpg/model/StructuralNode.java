package com.dbm.cpg.model;

import java.util.Objects;

public final class StructuralNode {
    private final String id;
    private final String role;

    public StructuralNode(String id, String role) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id is required");
        this.id = id;
        this.role = role == null ? "UNKNOWN" : role;
    }

    public String getId() { return id; }
    public String getRole() { return role; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StructuralNode)) return false;
        StructuralNode that = (StructuralNode) o;
        return id.equals(that.id);
    }

    @Override public int hashCode() { return Objects.hash(id); }

    @Override public String toString() { return id + "(" + role + ")"; }
}
