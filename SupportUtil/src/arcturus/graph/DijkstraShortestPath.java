package arcturus.graph;

import arcturus.util.IndexPriorityQueue;

import java.util.LinkedList;
import java.util.List;

public class DijkstraShortestPath {
    private final DirectedEdge[] edgeTo;
    private final double[] distTo;
    private final IndexPriorityQueue<Double> queue;
    public DijkstraShortestPath(WeightedDigraph graph, int source) {
        edgeTo = new DirectedEdge[graph.verticesCount()];
        distTo = new double[graph.verticesCount()];
        queue = new IndexPriorityQueue<>(graph.verticesCount());
        for (int v = 0; v < graph.verticesCount(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0;
        queue.insert(source, distTo[source]);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (DirectedEdge e : graph.adjacencies(v)) {
                relax(e);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public List<DirectedEdge> pathTo(int v) {
        LinkedList<DirectedEdge> path = new LinkedList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.addFirst(e);
        }
        return path;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (queue.contains(w)) queue.decreaseKey(w, distTo[w]);
            else queue.insert(w, distTo[w]);
        }
    }
}
