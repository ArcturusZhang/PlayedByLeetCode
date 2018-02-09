package arcturus.util;

import java.util.*;

public class ListDGraph<V> implements DirectedGraph<V> {
    private LinkedList<VE> vertexes;

    public ListDGraph() {
        vertexes = new LinkedList<>();
    }

    /**
     * 添加顶点（未作去重操作）
     *
     * @param v 要添加的顶点
     * @return 如果添加成功则返回顶点编号，失败返回-1
     */
    @Override
    public int add(V v) {
        int index = -1;
        if (v != null) {
            VE ve = new VE(v);
            vertexes.add(ve);
            index = vertexes.indexOf(ve);
        }
        return index;
    }

    /**
     * 添加一条边
     *
     * @param edge 要添加的边
     * @return {@code true}如果添加成功，否则返回{@code false}
     */
    @Override
    public boolean add(Edge<V> edge) {
        if (edge == null) return false;
        VE ve = getVE(edge.getStart());
        if (ve != null) { // 说明边的起点在顶点列表中
            ve.addEdge(edge);
            return true;
        }
        return false; // 边的起点不在顶点列表中，添加失败
    }

    /**
     * 删除一个顶点，与其相连的边也会被删除。
     *
     * @param v 要删除的顶点
     * @return 被删除的顶点，如顶点不存在则返回{@code null}
     */
    @Override
    public V remove(V v) {
        V result = null;
        VE ve = removeVE(v);
        if (ve != null) { // 说明存在这样的顶点
            result = ve.v;
        }
        removeRelatedEdges(v); // 删除所有以v为终点的边（以v为起点的边不需理会）
        return result;
    }

    /**
     * 删除一条边
     *
     * @param edge 要删除的边
     * @return 被删除的边，如不存在这样的边则返回{@code null}
     */
    @Override
    public Edge<V> remove(Edge<V> edge) {
        if (edge == null) return null;
        Edge<V> result = null;
        VE ve = getVE(edge.getStart());
        if (ve != null) {
            result = ve.removeEdge(edge.getEnd());
        }
        return result;
    }

    /**
     * 通过编号获得一个顶点
     *
     * @param index 顶点编号
     * @return 对应编号的顶点
     */
    @Override
    public V get(int index) {
        V result = null;
        if (index >= 0 && index < vertexes.size()) {
            VE ve = vertexes.get(index);
            if (ve != null) result = ve.v;
        }
        return result;
    }

    /**
     * 通过编号获得一条边
     *
     * @param start 边起始顶点的编号
     * @param end   边结束顶点的编号
     * @return 对应编号的边
     */
    @Override
    public Edge<V> get(int start, int end) {
        Edge<V> result = null;
        V startVertex = get(start);
        V endVertex = get(end);
        if (startVertex != null && endVertex != null) {
            VE ve = getVE(startVertex);
            if (ve != null) {
                result = ve.getEdge(endVertex);
            }
        }
        return result;
    }

    /**
     * 得到当前图的迭代器
     *
     * @param type 迭代类型
     * @param root 迭代起点
     * @return 迭代器
     */
    @Override
    public Iterator<V> iterator(IterationType type, V root) {
        switch (type) {
            case BFS:
                return new BFSIterator(root);
            case DFS:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * 得到当前图的默认模式迭代器
     *
     * @param root 迭代起点
     * @return 迭代器
     */
    @Override
    public Iterator<V> iterator(V root) {
        return iterator(IterationType.BFS, root);
    }

    private VE getVE(V v) {
        if (v == null) return null;
        VE result = null;
        for (VE ve : vertexes) {
            if (v.equals(ve.v)) {
                result = ve;
                break;
            }
        }
        return result;
    }

    private VE removeVE(V v) {
        if (v == null) return null;
        VE result = null;
        for (VE ve : vertexes) {
            if (v.equals(ve.v)) {
                result = ve;
                vertexes.remove(ve);
                break;
            }
        }
        return result;
    }

    /**
     * 删除所有以{@code v}为终点的边
     *
     * @param v 边的终点
     */
    private void removeRelatedEdges(V v) {
        if (v == null) return;
        for (VE ve : vertexes) {
            ve.removeEdge(v);
        }
    }

    private class VE {
        private V v;
        private List<Edge<V>> adjEdges;

        VE(V v) {
            this.v = v;
            this.adjEdges = new LinkedList<>();
        }

        private void ensureEdgeStart(Edge<V> e) {
            if (!e.getStart().equals(v)) throw new EdgeStartVertexDisMatchesException();
        }

        /**
         * 添加一条边。
         *
         * @param e 添加的边
         * @return {@code true}如果添加成功，否则返回{@code false}
         */
        boolean addEdge(Edge<V> e) {
//            ensureEdgeStart(e);
            boolean flag = getEdge(e.getEnd()) == null;
            if (flag) adjEdges.add(e);
            return flag;
        }

        /**
         * 获得以特定顶点为末尾的边
         *
         * @param end 结尾顶点
         * @return 返回相应的边，如不存在返回{@code null}
         */
        Edge<V> getEdge(V end) {
            if (end == null) return null;
            Edge<V> result = null;
            for (Edge<V> edge : adjEdges) {
                if (edge.getEnd() != null && edge.getEnd().equals(end)) {
                    result = edge;
                    break;
                }
            }
            return result;
        }

        /**
         * 删除以特定顶点为末尾的边
         *
         * @param end 结尾顶点
         * @return 返回被删除的边，如不存在返回{@code null}
         */
        Edge<V> removeEdge(V end) {
            if (end == null) return null;
            Edge<V> result = null;
            for (Edge<V> edge : adjEdges) {
                if (edge.getEnd() != null && edge.getEnd().equals(end)) {
                    result = edge;
                    adjEdges.remove(edge);
                    break;
                }
            }
            return result;
        }
    }

    private class BFSIterator implements Iterator<V> {
        private Set<V> visited = null;
        private Queue<V> remained = null;

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
            V v = remained.poll();
            // 将以顶点v为顶点的所有边的终点加入队列
            if (v != null) {
                visited.add(v);
                VE ve = getVE(v);
                if (ve != null) {
                    List<Edge<V>> edges = ve.adjEdges;
                    for (Edge<V> edge : edges) {
                        V end = edge.getEnd();
                        if (!visited.contains(end) && !remained.contains(end)) {
                            remained.offer(end);
                        }
                    }
                }
            }
            return v;
        }
    }
}
