package arcturus.util;

import java.util.Iterator;

public interface DirectedGraph<V> {
    /**
     * 添加顶点，添加成功返回顶点编号
     *
     * @param v 要添加的顶点
     * @return 如果添加成功则返回顶点编号，失败返回-1
     */
    int add(V v);

    /**
     * 添加一条边
     *
     * @param edge 要添加的边
     * @return {@code true}如果添加成功，否则返回{@code false}
     */
    boolean add(Edge<V> edge);

    default void addAll(V... vs) {
        for (V v : vs) {
            add(v);
        }
    }

    default void addAll(Edge<V>... edges) {
        for (Edge<V> edge : edges) {
            add(edge);
        }
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
     * 通过编号获得一个顶点
     *
     * @param index 顶点编号
     * @return 对应编号的顶点
     */
    V get(int index);

    /**
     * 通过编号获得一条边
     *
     * @param start 边起始顶点的编号
     * @param end   边结束顶点的编号
     * @return 对应编号的边
     */
    Edge<V> get(int start, int end);

    /**
     * 得到当前图的迭代器
     *
     * @param type 迭代类型
     * @param root 迭代起点
     * @return 迭代器
     */
    Iterator<V> iterator(IterationType type, V root);

    /**
     * 得到当前图的默认模式迭代器
     *
     * @param root 迭代起点
     * @return 迭代器
     */
    Iterator<V> iterator(V root);
}
