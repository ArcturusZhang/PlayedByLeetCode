import arcturus.util.DirectedGraph;
import arcturus.util.Edge;
import arcturus.util.ListDGraph;

import java.util.Iterator;

public class DGraphTest {
    public static void main(String[] args) {
        DirectedGraph<String> graph = new ListDGraph<>();
        graph.addAll("v1", "v2", "v3", "v4", "v5", "v6", "v7");
        graph.addAll(Edge.getEdges("v1", "v2", "v3", "v4"));
        graph.addAll(Edge.getEdges("v2", "v4", "v5"));
        graph.addAll(Edge.getEdges("v3", "v6"));
        graph.addAll(Edge.getEdges("v4", "v6", "v7"));
        graph.addAll(Edge.getEdges("v5", "v7"));
        Iterator<String> iterator = graph.iterator("v1");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
