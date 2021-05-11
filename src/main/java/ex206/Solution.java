package ex206;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/13 11:40
 * @Version 1.0
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
