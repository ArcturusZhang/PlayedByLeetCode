package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class DFSReverseOrder {
    private boolean[] visited;
    private LinkedList<Integer> reverseOrder;
    public DFSReverseOrder(Digraph graph) {
        visited = new boolean[graph.verticesCount()];
        reverseOrder = new LinkedList<>();
        for (int v = 0; v < graph.verticesCount(); v++)
            if (!visited[v]) dfs(graph, v);
    }

    private void dfs(Digraph graph, int v) {
        visited[v] = true;
        for (int w : graph.adjacencies(v)) {
            if (!visited[w]) dfs(graph, w);
        }
        reverseOrder.addFirst(v);
    }

    /**
     * 返回有向图的DFS顺序，如果有向图是无环的，那么这个顺序就是这个有向无环图的拓扑排序
     * @return
     */
    public List<Integer> reversePost() {
        return reverseOrder;
    }

    /**
     * 返回有向无环图的拓扑排序
     * @return
     */
    public List<Integer> topologicalSort() {
        return reverseOrder;
    }

    public static void main(String[] args) {
        Digraph graph = DigraphGenerator.simple(6, 6);
        System.out.println(graph);
        DFSReverseOrder order = new DFSReverseOrder(graph);
        System.out.println(order.reverseOrder);
    }
}
