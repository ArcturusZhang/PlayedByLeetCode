import java.util.*;

/**
 * 利用BFS来做拓扑排序。
 * 首先需要统计每个顶点的“入度”，一个顶点的入度等于以此顶点为终点的边的条数。
 * 维护一个队列，首先将所有入度为零的顶点入队。当队列非空时进行循环，取出队列的第一个顶点，依次考察与此顶点相邻的顶点。
 * 将这些顶点的入度减一，如果顶点入度减为0，则入队。
 * 这个循环中，各个顶点出队的顺序即为一个可能的拓扑排序。
 * 因此，循环结束时，考察循环次数，如果循环次数等于顶点总数，则图中无环，存在拓扑排序；反之则不存在相应的拓扑排序
 */
public class Solution2 extends Solution {
    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 统计每一个点的“入度”（即有几条不同的边以此点为终点）
        int[] indegrees = new int[numCourses];
        Set<Integer>[] adjacencies = (HashSet<Integer>[]) new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) adjacencies[i] = new HashSet<>();
        for (int[] edge : prerequisites) {
            adjacencies[edge[0]].add(edge[1]);
            indegrees[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int w : adjacencies[v]) {
                indegrees[w]--;
                if (indegrees[w] == 0) queue.offer(w);
            }
        }
        return count == numCourses;
    }
}
