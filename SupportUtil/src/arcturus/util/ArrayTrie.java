package arcturus.util;

public class ArrayTrie implements Trie {
    private TrieNode root;
    private boolean caseSensitive;

    public ArrayTrie() {
        caseSensitive = false;
        root = new TrieNode('0', caseSensitive);
    }

    public ArrayTrie(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        root = new TrieNode('0', caseSensitive);
    }

    @Override
    public void insert(String word) {
        if (word == null) return;
        if (!caseSensitive) word = word.toUpperCase();
        insertNode(root, word, 0);
    }

    private void insertNode(TrieNode node, String word, int start) {
        if (start == word.length()) return;
        int k = word.charAt(start) - 'A';
        if (node.children[k] == null) {
            node.children[k] = new TrieNode(word.charAt(start), caseSensitive);
        }
        if (start == word.length() - 1) {
            node.children[k].freq++;
        }
        insertNode(node.children[k], word, start + 1);
    }

    @Override
    public boolean search(String word) {
        TrieNode node = root;
        if (!caseSensitive) word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'A';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return node.freq != 0;
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        if (!caseSensitive) prefix = prefix.toUpperCase();
        for (int i = 0; i < prefix.length(); i++) {
            int k = prefix.charAt(i) - 'A';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return true;
    }

    private static class TrieNode {
        char c;
        TrieNode[] children;
        int freq;

        TrieNode(char c, boolean caseSensitive) {
            this.c = c;
            if (caseSensitive) children = new TrieNode[56];
            else children = new TrieNode[26];
            freq = 0;
        }
    }
}
