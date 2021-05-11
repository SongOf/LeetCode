package ex208;

/**
 * @author SongOf
 * @ClassName Trie
 * @Description
 * @Date 2021/4/1 16:23
 * @Version 1.0
 */
public class Trie {
    private boolean is_end;
    private Trie[] next;

    public Trie() {
        is_end = false;
        next = new Trie[26];
    }

    public void insert(String word) {//插入单词
        Trie root = this;
        char[] w = word.toCharArray();
        for(int i = 0; i < w.length; ++i) {
            if(root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
            root = root.next[w[i]-'a'];
        }
        root.is_end = true;
    }

    public boolean search(String word){//查找单词
        Trie root = this;
        char[] w = word.toCharArray();
        for(int i = 0; i < w.length; ++i){
            if(root.next[w[i]-'a'] == null) return false;
            root = root.next[w[i] - 'a'];
        }
        return root.is_end;
    }

    public boolean startsWith(String prefix){//查找前缀
        Trie root = this;
        char[] p = prefix.toCharArray();
        for(int i = 0; i < p.length; ++i){
            if(root.next[p[i] - 'a'] == null) return false;
            root = root.next[p[i] - 'a'];
        }
        return true;
    }
}
