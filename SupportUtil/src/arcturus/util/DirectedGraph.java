package arcturus.util;

import java.util.Iterator;
import java.util.List;

public interface DirectedGraph<V> {
    /**
     * 添加顶点
     *
     * @param v 要添加的顶点
     * @return {@code true}如果添加成功，否则返回{@code false}
     */
    boolean add(V v);

    default void addAll(V... vs) {
        for (V v : vs) add(v);
    }

    /**
     * 添加一条边
     *
     * @param edge 要添加的边
     * @return {@code true}如果添加成功，否则返回{@code false}
     */
    boolean add(Edge<V> edge);

    default void addAll(Edge<V>... edges) {
        for (Edge<V> edge : edges) add(edge);
    }

    /**
     * 删除一个顶点，与其相连的边也会被删除。
     *
     * @param v 要删除的顶点
     * @return 被删除的顶点，如顶点不存在则返回{@code null}
     */
    V remove(V v);

    /**
     * 删除一条边
     *
     * @param edge 要删除的边
     * @return 被删除的边，如不存在这样的边则返回{@code null}
     */
    Edge<V> remove(Edge<V> edge);

    /**
     * 得到当前图的迭代器
     *
     * @param type 迭代类型
     * @param root 迭代起点
     * @return 迭代器
     */
    default Iterator<V> iterator(IterationType type, V root) {
        return iterator(root);
    }

    /**
     * 得到当前图的默认模式迭代器
     *
     * @param root 迭代起点
     * @return 迭代器
     */
    Iterator<V> iterator(V root);

    /**
     * 返回有向图的一个拓扑排序
     *
     * @return 有向图的拓扑排序
     * @throws CyclicGraphException 当图中含有环时抛出异常
     */
    List<V> topologicalSort() throws CyclicGraphException;
}
