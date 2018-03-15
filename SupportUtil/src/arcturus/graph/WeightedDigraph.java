package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private final List<DirectedEdge>[] adj;

    public WeightedDigraph(int vertices) {
        this.vertices = vertices;
        edges = 0;
        adj = (List<DirectedEdge>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from(), w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
    }

    public List<DirectedEdge> adjacencies(int v) {
        validateVertex(v);
        return adj[v];
    }

    public List<DirectedEdge> edges() {
        List<DirectedEdge> list = new LinkedList<>();
        for (int v = 0; v < vertices; v++) {
            list.addAll(adjacencies(v));
        }
        return list;
    }

    public int verticesCount() {
        return vertices;
    }

    public int edgesCount() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices).append(" ").append(edges).append(NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(v).append(": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e).append("  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices - 1));
    }
}
