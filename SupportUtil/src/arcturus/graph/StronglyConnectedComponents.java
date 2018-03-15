package arcturus.graph;

import java.util.List;

public class StronglyConnectedComponents {
    private boolean[] visited;
    private int[] id;
    private int count;
    public StronglyConnectedComponents(Digraph graph) {
        visited = new boolean[graph.verticesCount()];
        id = new int[graph.verticesCount()];
        count = 0;
        List<Integer> reverseOrder = new DFSReverseOrder(graph.reverse()).reversePost();
        for (int v : reverseOrder) {
            if (!visited[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        visited[v] = true;
        id[v] = count;
        for (int w : graph.adjacencies(v)) {
            if (!visited[w]) dfs(graph, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }
}
