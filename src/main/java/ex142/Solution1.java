package ex142;

import ex141.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 15:04
 * @Version 1.0
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode ptr=head;
                while (ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
