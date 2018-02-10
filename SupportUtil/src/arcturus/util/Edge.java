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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj instanceof Edge<?>) {
            Edge<V> aEdge = (Edge<V>) obj;
            return this.start.equals(aEdge.start) && this.end.equals(aEdge.end) && this.weight == aEdge.weight;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        long f = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (f ^ (f >>> 32));
        return result;
    }

    /**
     * 解析传输的数据文本，返回有向图的一条边。
     * 数据格式：
     * (起点, 终点)
     * @param data 数据文本
     * @return 有向图的一条边
     */
    public static Edge<String> parse(String data, String separator) {
        int start = 0, end = data.length();
        if (data.charAt(0) == '(') ++start;
        if (data.charAt(data.length() - 1) == ')') --end;
        data = data.substring(start, end);
        String[] strings = data.split(separator);
        if (strings.length == 2) return new Edge<>(strings[0], strings[1]);
        if (strings.length == 3) {
            try {
                return new Edge<>(strings[0], strings[1], Double.valueOf(strings[2]));
            } catch (Exception e) {
                throw new FormatException(strings[2]);
            }
        }
        throw new FormatException(data);
    }

    public static Edge<String> parse(String data) {
        return parse(data, ", ");
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
