package sword2offer.p35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/5/9 11:48
 * @Version 1.0
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        Node head1 = new Node(-1);
        Node cur1 = head1;

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while(cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur1.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
        }

        cur = head;
        cur1 = head1.next;
        while(cur != null) {
            cur1.random = map.get(cur.random);
            cur = cur.next;
            cur1 = cur1.next;
        }

        return head1.next;
    }
}
