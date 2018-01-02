import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public abstract class Solution {
    public abstract boolean hasNext();

    public abstract int next();

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[5, 3, 8, 1, 4, 6, 7]");
        testCases(new BSTIterator(root));
    }

    private static void testCases(Solution solution) {
        List<Integer> result = new ArrayList<>();
        while (solution.hasNext()) {
            result.add(solution.next());
        }
        System.out.println(result);
    }
}
