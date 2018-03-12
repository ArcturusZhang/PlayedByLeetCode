package arcturus.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph implements Graph {
    private final int vertexes;
    private int edges;
    private final List<Integer>[] adj;

    public UndirectedGraph(int V) {
        this.vertexes = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < vertexes; v++) {
            adj[v] = new ArrayList<>();
        }
        edges = 0;
    }

    /**
     * Add an edge to this graph. (parallel edges allowed)
     * @param v source vertex of the edge
     * @param w destination vertex of the edge
     */
    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    @Override
    public List<Integer> adjacencies(int v) {
        return adj[v];
    }

    @Override
    public int vertexesCount() {
        return vertexes;
    }

    @Override
    public int edgesCount() {
        return edges;
    }
}
