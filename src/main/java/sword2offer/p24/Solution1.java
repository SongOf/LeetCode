package sword2offer.p24;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode listTemp=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return listTemp;
    }
}
