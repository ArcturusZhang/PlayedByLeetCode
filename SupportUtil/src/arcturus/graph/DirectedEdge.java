package arcturus.graph;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return v + " -> " + w + " " + String.format("%5.2f", weight);
    }
}
