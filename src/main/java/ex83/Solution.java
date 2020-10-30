package ex83;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow=head,fast=head;
        while (fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
