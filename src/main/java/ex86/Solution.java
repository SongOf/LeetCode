package ex86;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/29 19:33
 * @Version 1.0
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode largeTail = largeHead;
        while (head != null) {
            if(head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            }
            else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }
        largeTail.next = null;
        smallTail.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        node4.next = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.partition(head, 3);
    }
}
