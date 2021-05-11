package ex148;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/12/5 15:52
 * @Version 1.0
 */
public class Solution {
    public ListNode sortList(ListNode head) {
       return sortListCore(head);
    }
    public ListNode sortListCore(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast !=null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return merge(sortListCore(head), sortListCore(slow));
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            }
            else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
       return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        head = solution.sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
