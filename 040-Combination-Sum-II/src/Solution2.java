import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 extends Solution {
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationCore(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void combinationCore(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0 && idx < candidates.length) {
            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i - 1] == candidates[i]) continue; // 去除重复的解
                current.add(candidates[i]);
                combinationCore(candidates, target - candidates[i], i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
