public abstract class AbstractTrie {
    public abstract void insert(String word);

    public abstract boolean search(String word);

    public abstract boolean startsWith(String prefix);

    public static void main(String[] args) {
        testCases(new Trie());
    }

    private static void testCases(AbstractTrie trie) {
        trie.insert("test");
        System.out.println(trie.search("test"));
        System.out.println(trie.search("tes"));
        System.out.println(trie.startsWith("test"));
        System.out.println(trie.startsWith("te"));
    }
}
