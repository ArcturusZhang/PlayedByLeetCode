package arcturus.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstPaths implements GraphPaths {
    private final boolean[] visited;
    private final int[] edgeTo;
    private final int[] distTo;
    private final int source;

    public BreadthFirstPaths(Graph graph, int source) {
        this.visited = new boolean[graph.vertexesCount()];
        this.edgeTo = new int[graph.vertexesCount()];
        this.distTo = new int[graph.vertexesCount()];
        this.source = source;
        bfs(graph);
    }

    private void bfs(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adjacencies(v)) {
                if (!visited[v]) {
                    queue.offer(w);
                    visited[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return visited[v];
    }

    /**
     * 返回从起点到v的最短路径，如果路径不存在返回空列表
     * @param v 终点
     * @return 记录从起点开始到终点的最短路径所经过的各个顶点的编号
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
