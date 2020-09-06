package sword2offer.p24;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode preNode=head;
        ListNode curNode=head.next;
        ListNode temp;
        preNode.next=null;
        while (curNode!=null){
            temp=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=temp;
        }
        return preNode;
    }
}
