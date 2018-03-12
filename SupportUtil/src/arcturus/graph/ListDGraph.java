package arcturus.graph;

import arcturus.util.FormatException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用邻接表实现的有向图类
 *
 * @param <V> 顶点类型
 */
@Deprecated
public class ListDGraph<V> implements DirectedGraph<V> {
    public static final String SEPARATOR1 = ", ";
    public static final String SEPARATOR2 = "; ";
    private Map<V, Set<Edge<V>>> adjMap;

    /**
     * 返回一个空的有向图
     */
    public ListDGraph() {
        adjMap = new HashMap<>();
    }

    /**
     * 利用给定的邻接表构造有向图
     *
     * @param adjMap 邻接表
     */
    public ListDGraph(Map<V, Set<Edge<V>>> adjMap) {
        this.adjMap = adjMap;
    }

    public ListDGraph(V[] vs, Edge<V>[] edges) {
        addAll(vs);
        addAll(edges);
    }

    /**
     * 利用给定的顶点列表和边列表构造有向图
     *
     * @param vs    顶点集合
     * @param edges 边集合
     */
    public ListDGraph(Collection<V> vs, Collection<Edge<V>> edges) {
        for (V v : vs) add(v);
        for (Edge<V> edge : edges) add(edge);
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
    public static ListDGraph<String> parse(String data, String separator, String separatorBetweenVertexesAndEdges) {
        Pattern pattern = Pattern.compile("(.+)" + separatorBetweenVertexesAndEdges + "\\[(.+)]");
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
        return parse(data, SEPARATOR1, SEPARATOR2);
    }

    @Override
    public boolean add(V v) {
        if (v != null && !adjMap.containsKey(v)) {
            adjMap.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Edge<V> edge) {
        if (edge == null || edge.getStart() == null || edge.getEnd() == null || !adjMap.containsKey(edge.getStart()))
            return false;
        return adjMap.get(edge.getStart()).add(edge);
    }

    @Override
    public V remove(V v) {
        if (v == null || !adjMap.containsKey(v)) return null; // 不包含此顶点，则没有任何顶点被删除
        adjMap.remove(v);
        removeRelatedEdges(v);
        return v;
    }

    @Override
    public Edge<V> remove(Edge<V> edge) {
        if (edge == null) return null;
        return adjMap.get(edge.getStart()).remove(edge) ? edge : null;
    }

    @Override
    public Iterator<V> iterator(V root) {
        return new BFSIterator(root);
    }

    @Override
    public List<V> topologicalSort() throws CyclicGraphException {
        // 1. 计算每个顶点的入度（即指向该顶点的边的条数）
        Map<V, Integer> inDegreeMap = new HashMap<>(adjMap.size());
        for (V v : adjMap.keySet()) { // 初始化每个顶点的入度为0
            inDegreeMap.put(v, 0);
        }
        for (V v : adjMap.keySet()) {
            for (Edge<V> edge : adjMap.get(v)) {
                V adjV = edge.getEnd();
                inDegreeMap.put(adjV, inDegreeMap.get(adjV) + 1);
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
            for (Edge<V> edge : adjMap.get(v)) { // 考虑所有与这个入度为零的顶点相邻的顶点
                V adjV = edge.getEnd();
                inDegreeMap.put(adjV, inDegreeMap.get(adjV) - 1); // 将所有相邻顶点入度-1
                if (inDegreeMap.get(adjV) == 0) queue.offer(adjV); // 将入度降为零的顶点入队
            }
        }
        if (sorted.size() != adjMap.size()) throw new CyclicGraphException("Cycle found in graph.");
        else return sorted;
    }

    /**
     * 获得有向图从{@code from}到{@code to}的所有可能的最短路径
     *
     * @param from 起点
     * @param to   终点
     * @return 最短路径的列表。如果不存在最短路径，返回空列表
     */
    @Override
    public List<List<V>> unweightedShortestPath(V from, V to) {
        List<List<V>> result = new LinkedList<>();
        if (!adjMap.containsKey(from) || !adjMap.containsKey(to)) return result;
        if (from.equals(to)) {
            result.add(new LinkedList<>(Arrays.asList(from)));
            return result;
        }
        Map<V, Set<V>> map = new HashMap<>(); // 新的邻接表
        Queue<V> queue = new LinkedList<>();
        queue.offer(from);
        map.put(from, new HashSet<>());
        boolean flag = true;
        while (!queue.isEmpty() && flag) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                V v = queue.poll();
                for (Edge<V> edge : adjMap.get(v)) { // 将v的相邻顶点加入队列
                    V adjV = edge.getEnd();
                    if (to.equals(adjV)) flag = false; // 如果本层遇到终点，那么下一层的循环将不会进行，即便相应的顶点已被加入队列
                    if (!map.containsKey(adjV) || to.equals(adjV)) map.get(v).add(adjV);
                    if (!map.containsKey(adjV)) map.put(adjV, new HashSet<>());
                    queue.offer(adjV);
                }
            }
        }
        // BFS确定最短路径上的邻接表（及最短路径长度），然后再利用DFS和求得的邻接表具体求最短路径。
        // 对于较复杂的问题，直接使用DFS寻找最短路径将面临内存不足的问题（时间复杂度是大致相当的）
        constructShortestPathFromAdjacentMap(map, from, to, result, new LinkedList<>());
        return result;
    }

    private void constructShortestPathFromAdjacentMap(Map<V, Set<V>> map, V from, V to, List<List<V>> result, LinkedList<V> current) {
        if (from.equals(to)) { // 回溯出口
            current.add(to);
            result.add(new LinkedList<>(current));
            current.removeLast();
        } else {
            current.add(from);
            for (V adj : map.get(from)) {
                constructShortestPathFromAdjacentMap(map, adj, to, result, current);
            }
            current.removeLast();
        }
    }

    /**
     * 获得有向图从{@code from}到{@code to}的最短路径长度
     *
     * @param from 起点
     * @param to   终点
     * @return 最短路径长度
     */
    @Override
    public int unweightedShortestPathLength(V from, V to) {
        if (!adjMap.containsKey(from) || !adjMap.containsKey(to)) return 0;
        if (from.equals(to)) return 0;
        Map<V, Integer> map = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        queue.offer(from);
        map.put(from, 0);
        boolean flag = true;
        while (!queue.isEmpty() && flag) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                V v = queue.poll();
                for (Edge<V> edge : adjMap.get(v)) {
                    V adjV = edge.getEnd();
                    if (to.equals(adjV)) flag = false; // 如果以达终点，阻止下一层循环进行
                    if (!map.containsKey(adjV)) {
                        map.put(adjV, map.get(v) + 1);
                        queue.offer(adjV);
                    }
                }
            }
        }
        return map.getOrDefault(to, 0);
    }

    @Override
    public List<List<V>> weightedShortestPath(V from, V to) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public double weightedShortestPathWeight(V from, V to) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 删除所有以{@code end}为终点的边
     *
     * @param end 边的终点
     */
    private void removeRelatedEdges(V end) {
        if (end == null) return;
        for (V v : adjMap.keySet()) {
            for (Edge<V> edge : adjMap.get(v)) {
                if (edge.getEnd().equals(end)) {
                    adjMap.get(v).remove(edge);
                    break;
                }
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
                for (Edge<V> edge : adjMap.get(start)) {
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
