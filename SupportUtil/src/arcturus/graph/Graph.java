package arcturus.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private final List<Integer>[] adj;

    public Graph(int V) {
        this.vertices = V;
        this.edges = 0;
        this.adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    /**
     * Add an edge to this graph. (parallel edges allowed)
     *
     * @param v source vertex of the edge
     * @param w destination vertex of the edge
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public List<Integer> adjacencies(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int verticesCount() {
        return vertices;
    }

    public int edgesCount() {
        return edges;
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices - 1));
    }

    public static int degree(Graph G, int v) {
        return G.degree(v);
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.verticesCount(); v++) {
            if (degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.edgesCount() / G.verticesCount();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.verticesCount(); v++) {
            for (int w : G.adjacencies(v)) if (v == w) count++;
        }
        return count / 2;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices).append(" vertices, ").append(edges).append(" edges ").append(NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
