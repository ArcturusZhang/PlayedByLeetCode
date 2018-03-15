package arcturus.graph;

import java.util.LinkedList;
import java.util.List;

public class CycleDetector {
    private boolean[] visited, inList;
    private int[] edgeTo;
    private LinkedList<Integer> cycle = null;

    public CycleDetector(Graph graph) {
        if (hasSelfLoop(graph)) return;
        if (hasParallelEdges(graph)) return;
        visited = new boolean[graph.verticesCount()];
        edgeTo = new int[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++)
            if (!visited[v]) dfs(graph, -1, v);
    }

    public CycleDetector(Digraph graph) {
        visited = new boolean[graph.verticesCount()];
        inList = new boolean[graph.verticesCount()];
        edgeTo = new int[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++)
            if (!visited[v] && cycle == null) dfs(graph, v);
    }

    public static void main(String[] args) {
        Graph graph = GraphGenerator.simple(10, 10);
        System.out.println(graph);
        CycleDetector finder = new CycleDetector(graph);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("Graph is acyclic");
        }
        Digraph digraph = DigraphGenerator.simple(10, 10);
        System.out.println(digraph);
        CycleDetector diFinder = new CycleDetector(digraph);
        if (diFinder.hasCycle()) {
            System.out.print("Directed cycle: ");
            for (int v : diFinder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("No directed cycle");
        }
    }

    private void dfs(Graph graph, int u, int v) {
        visited[v] = true;
        for (int w : graph.adjacencies(v)) {
            if (cycle != null) return;
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(graph, v, w);
            } else if (w != u) {
                cycle = new LinkedList<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.addFirst(x);
                }
                cycle.addFirst(w);
                cycle.addFirst(v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        inList[v] = true;
        visited[v] = true;
        for (int w : graph.adjacencies(v)) {
            if (cycle != null) return;
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (inList[w]) {
                cycle = new LinkedList<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.addFirst(x);
                }
                cycle.addFirst(w);
                cycle.addFirst(v);
            }
        }
        inList[v] = false;
    }

    private boolean hasSelfLoop(Graph graph) {
        for (int v = 0; v < graph.verticesCount(); v++) {
            for (int w : graph.adjacencies(v)) {
                if (v == w) {
                    cycle = new LinkedList<>();
                    cycle.add(v);
                    cycle.add(v);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasParallelEdges(Graph graph) {
        visited = new boolean[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++) {
            for (int w : graph.adjacencies(v)) {
                if (visited[w]) {
                    cycle = new LinkedList<>();
                    cycle.add(v);
                    cycle.add(w);
                    cycle.add(v);
                    return true;
                }
                visited[w] = true;
            }
            for (int w : graph.adjacencies(v)) {
                visited[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public List<Integer> cycle() {
        return cycle == null ? new LinkedList<>() : cycle;
    }
}
