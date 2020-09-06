package sword2offer.p25;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode mergeList=new ListNode(-1);
        ListNode mergeRes=mergeList;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                mergeList.next=l1;
                mergeList=l1;
                l1=l1.next;
            }else {
                mergeList.next=l2;
                mergeList=l2;
                l2=l2.next;
            }
        }
        mergeList.next=null;
        if(l1!=null){
            mergeList.next=l1;
        }
        if(l2!=null){
            mergeList.next=l2;
        }
        return mergeRes.next;
    }
}
