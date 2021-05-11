package ex141;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/28 19:07
 * @Version 1.0
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val=x;
            next=null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}
