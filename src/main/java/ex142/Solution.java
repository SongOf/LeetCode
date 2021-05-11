package ex142;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 15:04
 * @Version 1.0
 */
public class Solution {
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
        Set<ListNode> list=new HashSet<>();
        while (head!=null){
            if(!list.add(head)){
                return head;
            }
            head=head.next;
        }
        return null;
    }
}
