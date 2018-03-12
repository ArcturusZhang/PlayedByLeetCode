package arcturus.graph;

public class ConnectedComponents {
    private final boolean[] visited;
    private final int[] id;
    private int count;
    public ConnectedComponents(Graph graph) {
        visited = new boolean[graph.vertexesCount()];
        id = new int[graph.vertexesCount()];
        count = 0;
        for (int v = 0; v < graph.vertexesCount(); v++) {
            if (!visited[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        id[v] = count;
        for (int w : graph.adjacencies(v)) {
            if (!visited[w]) dfs(graph, w);
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }
}
