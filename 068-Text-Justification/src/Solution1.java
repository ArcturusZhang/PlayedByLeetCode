import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 很麻烦的一道题。逻辑略复杂但算法并不难。
     * @param words
     * @param maxWidth
     * @return
     */
    @Override
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
        fullJustifyCore(words, maxWidth, 0, result);
        return result;
    }

    private void fullJustifyCore(String[] words, int maxWidth, int start, List<String> result) {
        if (start < words.length) {
            int space = maxWidth;
            int wordCount = 0;
            int end = start;
            List<String> line = new ArrayList<>();
            while (end < words.length && space >= words[end].length() + wordCount) {
                line.add(words[end]);
                space -= words[end].length() + wordCount;
                // +wordCount表示单词后面接的空格，一行中的最后一个单词末尾是没有空格的，除非这一行就只有一个单词
                end++;
                if (wordCount == 0) wordCount = 1;
            }
            space += line.size() - 1; // 最后一个单词最后不加空格
            StringBuilder sb = new StringBuilder();
            if (end >= words.length) {// 最后一行所有额外的空格都加在末尾
                for (int i = 0; i < line.size(); i++) {
                    sb.append(line.get(i));
                    if (i < line.size() - 1) {
                        sb.append(" ");
                        space--;
                    }
                }
                for (int i = 0; i < space; i++) sb.append(" ");
            } else {
                if (line.size() > 1) {
                    int spacePerWord = space / (line.size() - 1);
                    int spaceRemain = space % (line.size() - 1);
                    for (int i = 0; i < line.size(); i++) {
                        sb.append(line.get(i));
                        if (i < line.size() - 1) { // 最后一个单词后面不加空格
                            for (int j = 0; j < spacePerWord; j++) sb.append(" ");
                            if (spaceRemain > 0) {
                                sb.append(" ");
                                spaceRemain--;
                            }
                        }
                    }
                } else { // line.size() == 1
                    sb.append(line.get(0));
                    for (int i = 0; i < space; i++) sb.append(" ");
                }
            }
            result.add(sb.toString());
            fullJustifyCore(words, maxWidth, end, result);
        }
    }
}
