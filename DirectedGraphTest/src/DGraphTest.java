import arcturus.util.DirectedGraph;
import arcturus.util.ListDGraph;

public class DGraphTest {
    public static void main(String[] args) {
        String data = "v1, v2, v3, v4, v5, v6, v7; "
                + "[(v1, v2), (v1, v3), (v1, v4), (v2, v4), (v2, v5), (v3, v6), (v4, v3), (v4, v6), (v4, v7), (v5, v4), (v5, v7), (v7, v6)]";
        DirectedGraph<String> graph = ListDGraph.parse(data);
        graph.iterator("v1").forEachRemaining(System.out::println);
        System.out.println("====================================");
        graph.iterator("v4").forEachRemaining(System.out::println);
        System.out.println("====================================");
        graph.iterator("v5").forEachRemaining(System.out::println);
        System.out.println("====================================");
        System.out.println(graph.topologicalSort());
    }
}
