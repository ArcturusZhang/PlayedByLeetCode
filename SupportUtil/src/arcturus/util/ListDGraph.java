package arcturus.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListDGraph<V> implements DirectedGraph<V> {
    private Map<V, Set<Edge<V>>> vertexes;

    public ListDGraph() {
        vertexes = new HashMap<>();
    }

    /**
     * 解析传输的数据文本，返回一个有向图。
     * 数据格式：
     * 顶点1, 顶点2, 顶点3, ..., 顶点n; [(起点1, 终点1), (起点2, 终点2), ..., (起点m, 终点m)]
     * 其中中括号和小括号是必须的。
     *
     * @param data 数据文本
     * @return 有向图
     */
    public static ListDGraph<String> parse(String data, String separator) {
        Pattern pattern = Pattern.compile("(.+); \\[(.+)]");
        Matcher matcher = pattern.matcher(data);
        String vertexString = null, edgeString = null;
        if (matcher.find()) {
            vertexString = matcher.group(1);
            edgeString = matcher.group(2);
        }
        if (vertexString == null || edgeString == null) throw new FormatException(data);
        String[] vertexes = vertexString.split(separator);
        String[] edgeStrings = edgeString.split("\\)" + separator + "\\(");
        ListDGraph<String> graph = new ListDGraph<>();
        graph.addAll(vertexes);
        for (String edge : edgeStrings) {
            graph.add(Edge.parse(edge, separator));
        }
        return graph;
    }

    public static ListDGraph<String> parse(String data) {
        return parse(data, ", ");
    }

    @Override
    public boolean add(V v) {
        if (v != null && !vertexes.containsKey(v)) {
            vertexes.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Edge<V> edge) {
        if (edge == null || edge.getStart() == null || edge.getEnd() == null || !vertexes.containsKey(edge.getStart()))
            return false;
        return vertexes.get(edge.getStart()).add(edge);
    }

    @Override
    public V remove(V v) {
        if (v == null || !vertexes.containsKey(v)) return null; // 不包含此顶点，则没有任何顶点被删除
        vertexes.remove(v);
        removeRelatedEdges(v);
        return v;
    }

    @Override
    public Edge<V> remove(Edge<V> edge) {
        if (edge == null) return null;
        Set<Edge<V>> edges = vertexes.get(edge.getStart());
        if (edges == null) return null;
        return edges.remove(edge) ? edge : null;
    }

    @Override
    public Iterator<V> iterator(V root) {
        return new BFSIterator(root);
    }

    @Override
    public List<V> topologicalSort() throws CyclicGraphException {
        // 1. 计算每个顶点的入度（即指向该顶点的边的条数）
        Map<V, Integer> inDegreeMap = new HashMap<>(vertexes.size());
        for (V v : vertexes.keySet()) { // 初始化每个顶点的入度为0
            inDegreeMap.put(v, 0);
        }
        for (V v : vertexes.keySet()) {
            for (Edge<V> edge : vertexes.get(v)) {
                inDegreeMap.put(edge.getEnd(), inDegreeMap.get(edge.getEnd()) + 1);
            }
        }
        System.out.println(inDegreeMap);
        // 2. 拓扑排序需要维护一个入度为零的顶点的集合（这里是一个队列）
        //    首先将所有入度为零的顶点加入队列中（初始化）；
        //    令队首元素出列，将其指向的所有其他顶点入度-1，并将新的入度将为零的顶点入队。重复此过程直到队列为空为止。
        //    最后判定所得结果是否为图中所有顶点，如还有顶点剩余或数量超出了图中顶点数，说明图中有环，抛出异常。
        List<V> sorted = new LinkedList<>();
        Queue<V> queue = new LinkedList<>();
        for (V v : inDegreeMap.keySet()) { // 将所有入度为零的顶点入队
            if (inDegreeMap.get(v) == 0) queue.offer(v);
        }
        while (!queue.isEmpty()) {
            V v = queue.poll();
            sorted.add(v);
            for (Edge<V> edge : vertexes.get(v)) { // 考虑所有与这个入度为零的顶点相邻的顶点
                V adjV = edge.getEnd();
                inDegreeMap.put(adjV, inDegreeMap.get(adjV) - 1); // 将所有相邻顶点入度-1
                if (inDegreeMap.get(adjV) == 0) queue.offer(adjV); // 将入度降为零的顶点入队
            }
        }
        if (sorted.size() != vertexes.size()) throw new CyclicGraphException("Cycle found in graph.");
        else return sorted;
    }

    /**
     * 获得有向图从{@code start}到{@code end}的所有可能的最短路径
     * @param start 起点
     * @param end 终点
     * @return 最短路径的列表。如果不存在最短路径，返回空列表
     * @throws CyclicGraphException 如果图中有环，抛出异常
     */
    public List<List<V>> unweightedShortestPath(V start, V end) throws CyclicGraphException {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除所有以{@code end}为终点的边
     *
     * @param end 边的终点
     */
    private void removeRelatedEdges(V end) {
        if (end == null) return;
        for (V v : vertexes.keySet()) {
            removeEdge(vertexes.get(v), end);
        }
    }

    private void removeEdge(Set<Edge<V>> adjEdges, V end) {
        for (Edge<V> edge : adjEdges) {
            if (edge.getEnd().equals(end)) {
                adjEdges.remove(edge);
                break;
            }
        }
    }

    private final class BFSIterator implements Iterator<V> {
        private Set<V> visited;
        private Queue<V> remained;

        public BFSIterator(V root) {
            visited = new HashSet<>();
            remained = new LinkedList<>();
            remained.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !remained.isEmpty();
        }

        @Override
        public V next() {
            V start = remained.poll();
            // 将以顶点v为顶点的所有边的终点加入队列
            if (start != null) {
                visited.add(start);
                for (Edge<V> edge : vertexes.get(start)) {
                    V end = edge.getEnd();
                    if (!visited.contains(end) && !remained.contains(end)) {
                        remained.offer(end);
                    }
                }
            }
            return start;
        }
    }
}
