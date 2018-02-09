package arcturus.util;

/**
 * 图的一条边
 * @param <Vertex> 图的顶点的数据类型
 */
public class Edge<Vertex> {
    private Vertex start;
    private Vertex end;
    private double weight;

    public Edge(Vertex start, Vertex end) {
        this(start, end, 1);
    }

    public Edge(Vertex start, Vertex end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Edge : [start: %s , end: %s , weight : %s]", start, end, weight);
    }
}
