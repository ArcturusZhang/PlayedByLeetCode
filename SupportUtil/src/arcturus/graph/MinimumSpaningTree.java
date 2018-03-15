package arcturus.graph;

import arcturus.util.UnionFind;
import arcturus.util.WeightedQuickUnionUF;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpaningTree {
    private final List<Edge> mst;
    private double weight;
    public MinimumSpaningTree(WeightedGraph graph) {
        mst = new LinkedList<>();
        weight = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (Edge edge : graph.edges()) {
            queue.offer(edge);
        }
        UnionFind uf = new WeightedQuickUnionUF(graph.verticesCount());
        while (!queue.isEmpty() && mst.size() < graph.verticesCount() - 1) {
            Edge edge = queue.poll();
            int v = edge.either(), w = edge.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(edge);
            }
        }
        for (Edge edge : mst) {
            weight += edge.getWeight();
        }
    }

    public List<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
