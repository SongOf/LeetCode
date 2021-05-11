package ex61;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/28 15:21
 * @Version 1.0
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode tail = head;
        int length = 0;
        while (cur != null) {
            length++;
            tail = cur;
            cur = cur.next;
        }
        tail.next = head;
        if(k > length) {
            k = k % length;
        }
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
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
        head = solution.rotateRight(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
