package ex25;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/2/26 22:32
 * @Version 1.0
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        hair.next = head;

        ListNode pre = hair;
        while(head != null) {
            ListNode tail = pre;
            for(int i = 0; i < k; i ++) {
                tail = tail.next;
                if(tail == null) return hair.next;
            }
            ListNode nxt = tail.next;
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];
            pre.next = head;
            tail.next = nxt;
            pre = tail;
            head = pre.next;
        }
        return hair.next;
    }
    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        while(prev != tail) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = solution.reverseKGroup(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
