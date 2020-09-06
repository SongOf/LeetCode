package sword2offer.p18;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode preNode=null;
        ListNode curNode=head;
        while (curNode!=null){
            if(curNode.val==val){
                if(preNode==null){
                    head=curNode.next;
                }else {
                    preNode.next=curNode.next;
                }
                return head;
            }
            preNode=curNode;
            curNode=curNode.next;
        }
        return head;
    }
}
