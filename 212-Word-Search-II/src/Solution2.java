import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 extends Solution {
    private TrieNode root = new TrieNode();
    private boolean[][] flag;

    /**
     * 利用Trie降低回溯所需的次数
     * @param board
     * @param words
     * @return
     */
    @Override
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        if (words == null || words.length == 0) return new ArrayList<>();
        int rows = board.length, cols = board[0].length;
        Set<String> result = new HashSet<>();
        flag = new boolean[rows][cols];
        addToTrie(words);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (root.child[board[row][col] - 'a'] != null) {
                    search(board, row, col, root, "", result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void addToTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    private void search(char[][] board, int row, int col, TrieNode node, String word, Set<String> result) {
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 || flag[row][col]) return; // 回溯出口
        if (node.child[board[row][col] - 'a'] == null) return; // 回溯出口
        flag[row][col] = true;
        node = node.child[board[row][col] - 'a'];
        if (node.isWord) result.add(word + board[row][col]);
        search(board, row - 1, col, node, word + board[row][col], result); // 向上
        search(board, row + 1, col, node, word + board[row][col], result); // 向下
        search(board, row, col - 1, node, word + board[row][col], result); // 向左
        search(board, row, col + 1, node, word + board[row][col], result); // 向右
        flag[row][col] = false; // 回溯
    }

    public class TrieNode {
        boolean isWord = false;
        TrieNode[] child = new TrieNode[26];
        TrieNode() {
        }
    }
}
