package ex117;

/**
 * @author SongOf
 * @ClassName Node
 * @Description
 * @Date 2021/3/26 1:28
 * @Version 1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
