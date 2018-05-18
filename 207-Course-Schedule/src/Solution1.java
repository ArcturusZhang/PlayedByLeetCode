import java.util.HashSet;
import java.util.Set;

/**
 * 检测一个有向图是否有环。首先将题目给的数组{@code prerequisites}转化为邻接表。
 * 然后在普通的DFS中增加一个数组变量{@code inList}用来记录当前这一趟DFS中，已经到达过的点。如果在这次DFS中重复访问了某个记录过的点两次，
 * 就说明这个有向图中有环
 */
public class Solution1 extends Solution {
    private boolean[] visited;
    private boolean[] inList;
    private Set<Integer>[] adjacencies;
    private boolean cyclic = false;

    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        inList = new boolean[numCourses];
        adjacencies = (HashSet<Integer>[]) new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) adjacencies[i] = new HashSet<>();
        for (int[] edge : prerequisites) {
            adjacencies[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < numCourses && !cyclic; i++) {
            dfs(i);
        }
        return !cyclic;
    }

    private void dfs(int start) {
        if (visited[start]) return;
        visited[start] = true;
        inList[start] = true;
        for (int end : adjacencies[start]) {
            if (inList[end]) cyclic = true;
            dfs(end);
        }
        inList[start] = false;
    }
}
