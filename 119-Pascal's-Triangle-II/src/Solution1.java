import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    @Override
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int row = 0; row < rowIndex; row++) {
            result.add(1);
            for (int i = result.size() - 1; i > 0; i--) {
                result.set(i, result.get(i - 1) + result.get(i));
            }
        }
        result.add(1);
        return result;
    }
}
