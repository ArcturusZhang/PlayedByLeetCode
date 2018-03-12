package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstPaths implements GraphPaths {
    private final boolean[] visited;
    private final int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph graph, int source) {
        this.visited = new boolean[graph.vertexesCount()];
        this.edgeTo = new int[graph.vertexesCount()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        for (int w : graph.adjacencies(v)) {
            if (!visited[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return visited[v];
    }

    /**
     * 返回一条从起点至给定点的路径（并非所有可能的路径），如不存在这样的路径，返回空列表
     * @param v 路径终点
     * @return 路径上各个顶点
     */
    @Override
    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}
