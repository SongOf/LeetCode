package sword2offer.p6;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode curNode=head;
        int listLength=0;
        while (curNode!=null){
            listLength++;
            curNode=curNode.next;
        }
        int[] res=new int[listLength];
        curNode=head;
        for(int i=listLength-1;i>=0;i--){
            res[i]=curNode.val;
            curNode=curNode.next;
        }
        return res;
    }
}
