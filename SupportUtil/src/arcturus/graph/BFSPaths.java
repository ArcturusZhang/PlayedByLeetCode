package arcturus.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSPaths implements Paths {
    private boolean[] visited;
    private int[] edgeTo;
    private int[] distTo;
    private int source;

    public BFSPaths(Graph graph, int source) {
        initialize(graph.verticesCount(), source);
        bfs(graph);
    }

    public BFSPaths(Digraph digraph, int source) {
        initialize(digraph.verticesCount(), source);
        bfs(digraph);
    }

    private void initialize(int vertices, int source) {
        this.visited = new boolean[vertices];
        this.edgeTo = new int[vertices];
        this.distTo = new int[vertices];
        this.source = source;
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
    }

    private void bfs(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        distTo[source] = 0;
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

    private void bfs(Digraph digraph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        distTo[source] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : digraph.adjacencies(v)) {
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
        validate(v);
        return visited[v];
    }

    /**
     * 返回从起点到v的最短路径，如果路径不存在返回空列表
     *
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

    public int distanceTo(int v) {
        validate(v);
        return distTo[v];
    }

    private void validate(int v) {
        if (v < 0 || v > visited.length)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (visited.length - 1));
    }
}
