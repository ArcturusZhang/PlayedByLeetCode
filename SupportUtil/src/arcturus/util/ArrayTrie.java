package arcturus.util;

/**
 * 前缀树的一个实现，其中所有单词将被转化为小写字母。
 */
public class ArrayTrie implements Trie {
    private TrieNode root;

    public ArrayTrie() {
        root = new TrieNode('0');
    }

    @Override
    public void insert(CharSequence word) {
        validates(word);
        insertNode(root, word, 0);
    }

    private void insertNode(TrieNode node, CharSequence word, int start) {
        if (start == word.length()) return;
        int k = word.charAt(start) - 'a';
        if (node.children[k] == null) {
            node.children[k] = new TrieNode(word.charAt(start));
        }
        if (start == word.length() - 1) {
            node.children[k].freq++;
        }
        insertNode(node.children[k], word, start + 1);
    }

    @Override
    public boolean search(CharSequence word) {
        validates(word);
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return node.freq != 0;
    }

    @Override
    public boolean startsWith(CharSequence prefix) {
        validates(prefix);
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int k = prefix.charAt(i) - 'a';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return true;
    }

    private void validates(CharSequence word) {
        if (word == null) throw new IllegalArgumentException("The input word must not be null.");
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'a' || c > 'z') throw new IllegalArgumentException("The input word must only contain lower case characters.");
        }
    }

    private static class TrieNode {
        char c;
        TrieNode[] children;
        int freq;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            freq = 0;
        }
    }
}
