import java.util.ArrayList;
import java.util.List;

public abstract class Solution {
    public abstract UndirectedGraphNode cloneGraph(UndirectedGraphNode node);

    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
