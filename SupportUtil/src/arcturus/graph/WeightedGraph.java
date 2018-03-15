package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private final List<Edge>[] adj;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        edges = 0;
        adj = (List<Edge>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
    }

    public List<Edge> adjacencies(int v) {
        validateVertex(v);
        return adj[v];
    }

    public List<Edge> edges() {
        List<Edge> list = new LinkedList<>();
        for (int v = 0; v < vertices; v++) {
            int selfLoops = 0;
            for (Edge e : adjacencies(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
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
            for (Edge e : adj[v]) {
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
