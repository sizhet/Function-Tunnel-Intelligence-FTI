package com.dbm.cpg.model;

import java.util.*;

public final class StructuralGraph {
    private final String name;
    private final Map<String, StructuralNode> nodes = new LinkedHashMap<String, StructuralNode>();
    private final List<StructuralEdge> edges = new ArrayList<StructuralEdge>();

    public StructuralGraph(String name) { this.name = name == null ? "UnnamedGraph" : name; }
    public String getName() { return name; }

    public StructuralGraph addNode(String id, String role) { nodes.put(id, new StructuralNode(id, role)); return this; }
    public StructuralGraph addEdge(String from, String to, String relation) { edges.add(new StructuralEdge(from, to, relation)); return this; }

    public Collection<StructuralNode> getNodes() { return Collections.unmodifiableCollection(nodes.values()); }
    public List<StructuralEdge> getEdges() { return Collections.unmodifiableList(edges); }
    public StructuralNode getNode(String id) { return nodes.get(id); }

    public boolean hasRole(String role) {
        for (StructuralNode node : nodes.values()) if (role.equals(node.getRole())) return true;
        return false;
    }

    public int indexOfRole(String role) {
        int i = 0;
        for (StructuralNode node : nodes.values()) {
            if (role.equals(node.getRole())) return i;
            i++;
        }
        return -1;
    }
}
