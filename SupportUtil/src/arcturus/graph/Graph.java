package arcturus.graph;

import java.util.List;

public interface Graph {
    void addEdge(int v, int w);
    List<Integer> adjacencies(int v);
    int vertexesCount();
    int edgesCount();

    static int degree(Graph G, int v) {
        return G.adjacencies(v).size();
    }

    static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.vertexesCount(); v++) {
            if (degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }

    static double averageDegree(Graph G) {
        return 2.0 * G.edgesCount() / G.vertexesCount();
    }

    static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.vertexesCount(); v++) {
            for (int w : G.adjacencies(v)) if (v == w) count++;
        }
        return count / 2;
    }
}
