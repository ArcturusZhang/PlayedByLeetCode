package arcturus.util;

public interface Trie {
    void insert(CharSequence word);

    boolean search(CharSequence word);

    boolean startsWith(CharSequence prefix);
}
