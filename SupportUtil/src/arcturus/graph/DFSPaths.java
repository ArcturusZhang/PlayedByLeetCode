package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class DFSPaths implements Paths {
    private boolean[] visited;
    private int[] edgeTo;
    private int source;

    public DFSPaths(Graph graph, int source) {
        initialize(graph.vertexesCount(), source);
        dfs(graph, source);
    }

    public DFSPaths(Digraph digraph, int source) {
        initialize(digraph.vertexesCount(), source);
        dfs(digraph, source);
    }

    private void initialize(int vertices, int source) {
        this.visited = new boolean[vertices];
        this.edgeTo = new int[vertices];
        this.source = source;
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

    private void dfs(Digraph digraph, int v) {
        visited[v] = true;
        for (int w : digraph.adjacencies(v)) {
            if (!visited[w]) {
                dfs(digraph, w);
                edgeTo[w] = v;
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        validate(v);
        return visited[v];
    }

    /**
     * 返回一条从起点至给定点的路径（并非所有可能的路径），如不存在这样的路径，返回空列表
     *
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

    private void validate(int v) {
        if (v < 0 || v > visited.length)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (visited.length - 1));
    }
}
