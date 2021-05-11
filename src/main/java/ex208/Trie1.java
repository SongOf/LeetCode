package ex208;

/**
 * @author SongOf
 * @ClassName Trie1
 * @Description
 * @Date 2021/4/1 17:42
 * @Version 1.0
 */
public class Trie1 {
    private boolean is_end;
    private Trie1[] next;

    public Trie1() {
        is_end = false;
        next = new Trie1[26];
    }

    public void insert(String word) {
        Trie1 root = this;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(root.next[chs[i] - 'a'] == null) root.next[chs[i] - 'a'] = new Trie1();
            root = root.next[chs[i] - 'a'];
        }
        root.is_end = true;
    }

    public boolean search(String word) {
        Trie1 tail = searchCore(word);
        return tail != null && tail.is_end;
    }
    public boolean startsWith(String word) {
        Trie1 tail = searchCore(word);
        return tail != null;
    }
    private Trie1 searchCore(String word) {
        Trie1 root = this;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(root.next[chs[i] - 'a'] == null) return null;
            root = root.next[chs[i] - 'a'];
        }
        return root;
    }
}
