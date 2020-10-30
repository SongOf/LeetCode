package sword2offer.p22;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null||k==0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (k>0){
            if(fast==null){
                return null;
            }else {
                fast=fast.next;
                k--;
            }
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
