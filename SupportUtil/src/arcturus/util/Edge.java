package arcturus.util;

/**
 * 图的一条边
 * @param <V> 图的顶点的数据类型
 */
public class Edge<V> {
    private V start;
    private V end;
    private double weight;

    public Edge(V start, V end) {
        this(start, end, 1);
    }

    public Edge(V start, V end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public V getStart() {
        return start;
    }

    public V getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Edge : [start: %s , end: %s , weight : %s]", start, end, weight);
    }

    public static <V> Edge<V>[] getEdges(V start, V... ends) {
        Edge<V>[] edges = new Edge[ends.length];
        for (int i = 0; i < ends.length; ++i) {
            edges[i] = new Edge<>(start, ends[i]);
        }
        return edges;
    }

    public static <V> Edge<V>[] getEdges(V start, V[] ends, double[] weights) {
        int length = Math.min(ends.length, weights.length);
        Edge<V>[] edges = new Edge[length];
        for (int i = 0; i < length; ++i) {
            edges[i] = new Edge<>(start, ends[i], weights[i]);
        }
        return edges;
    }
}
