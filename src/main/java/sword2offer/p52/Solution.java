package sword2offer.p52;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int lengthA=0;
        int lengthB=0;
        ListNode curNode=headA;
        while (curNode!=null){
            lengthA++;
            curNode=curNode.next;
        }
        curNode=headB;
        while (curNode!=null){
            lengthB++;
            curNode=curNode.next;
        }
        if(lengthA>=lengthB){
            return getIntersectionNodeCore(headA,lengthA,headB,lengthB);
        }else {
            return getIntersectionNodeCore(headB,lengthB,headA,lengthA);
        }
    }
    public ListNode getIntersectionNodeCore(ListNode headA,int lengthA, ListNode headB,int lengthB){
        int d=lengthA-lengthB;
        ListNode curNodeA=headA;
        ListNode curNodeB=headB;
        for(int i=0;i<d;i++){
            curNodeA=curNodeA.next;
        }
        while (curNodeA!=null&&curNodeB!=null){
            if(curNodeA==curNodeB){
                return curNodeA;
            }
            curNodeA=curNodeA.next;
            curNodeB=curNodeB.next;
        }
        return null;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode b1=new ListNode(4);
        ListNode b2=new ListNode(5);
        ListNode b3=new ListNode(6);
        ListNode c1=new ListNode(7);
        ListNode c2=new ListNode(8);
        ListNode c3=new ListNode(9);
        a1.next=a2;
        a2.next=c1;
        c1.next=c2;
        c2.next=c3;
        b1.next=b2;
        b2.next=b3;
        b3.next=c1;
        c3.next=null;
        System.out.println(solution.getIntersectionNode(a1,b1).val);
    }
}
