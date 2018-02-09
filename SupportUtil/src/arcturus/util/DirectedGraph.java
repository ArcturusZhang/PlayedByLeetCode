package arcturus.util;

import java.util.Iterator;

public interface DirectedGraph<Vertex> {
    /**
     * 添加顶点，添加成功返回顶点编号
     * @param vertex 要添加的顶点
     * @return 如果添加成功则返回顶点编号，失败返回-1
     */
    public int add(Vertex vertex);

    /**
     * 添加一条边
     * @param edge 要添加的边
     */
    public void add(Edge<Vertex> edge);

    /**
     * 删除一个顶点，与其相连的边也会被删除。
     * @param vertex 要删除的顶点
     * @return 被删除的顶点，如顶点不存在则返回{@code null}
     */
    public Vertex remove(Vertex vertex);

    /**
     * 删除一条边
     * @param edge 要删除的边
     * @return 被删除的边，如不存在这样的边则返回{@code null}
     */
    public Edge<Vertex> remove(Edge<Vertex> edge);

    /**
     * 通过编号获得一个顶点
     * @param index 顶点编号
     * @return 对应编号的顶点
     */
    public Vertex get(int index);

    /**
     * 通过编号获得一条边
     * @param start 边起始顶点的编号
     * @param end 边结束顶点的编号
     * @return 对应编号的边
     */
    public Edge<Vertex> get(int start, int end);

    /**
     * 得到当前图的迭代器
     * @param type 迭代类型
     * @param root 迭代起点
     * @return 迭代器
     */
    public Iterator<Vertex> iterator(IterationType type, Vertex root);

    /**
     * 将图转换为无环图
     */
    public void convertDAG();
}
