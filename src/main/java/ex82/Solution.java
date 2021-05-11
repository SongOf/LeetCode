package ex82;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/27 15:38
 * @Version 1.0
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(Integer.MAX_VALUE, head);
        ListNode res = pre;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            while(next != null && cur.val == next.val) {
                ListNode tmp = next;
                next = next.next;
                tmp.next = null;
            }
            if(next == cur.next) {
                pre = cur;
                cur = next;
            }
            else {
                pre.next = next;
                cur = next;
            }
        }
        head = res.next;
        res.next = null;
        return head;
    }
}
