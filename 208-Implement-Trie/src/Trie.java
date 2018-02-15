public class Trie extends AbstractTrie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    @Override
    public void insert(String word) {
        if (word == null) return;
        insertNode(root, word, 0);
    }

    private void insertNode(TrieNode node, String word, int start) {
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
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return node.freq != 0;
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int k = prefix.charAt(i) - 'a';
            if (node.children[k] == null) return false;
            node = node.children[k];
        }
        return true;
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
