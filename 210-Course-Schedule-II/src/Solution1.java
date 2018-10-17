import java.util.*;

public class Solution1 extends Solution {
    @Override
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] condition : prerequisites) {
            nodes[condition[1]].adj.add(condition[0]);
            nodes[condition[0]].inDegree++;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.inDegree - o2.inDegree;
            }
        });
        for (int i = 0; i < numCourses; i++) {
            if (nodes[i].inDegree == 0) {
                queue.offer(nodes[i]);
            }
        }
        if (queue.isEmpty()) return new int[0];
        int managed = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result[managed++] = node.index;
            for (int i : node.adj) {
                nodes[i].inDegree--;
                if (nodes[i].inDegree == 0) queue.offer(nodes[i]);
            }
        }
        if (managed != numCourses) return new int[0];
        return result;
    }

    private class Node {
        int index;
        List<Integer> adj;
        int inDegree;

        Node(int index) {
            this.index = index;
            adj = new ArrayList<>();
        }
    }
}
