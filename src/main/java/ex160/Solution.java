package ex160;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/12/5 16:18
 * @Version 1.0
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int lengthA=0;
        int lengthB=0;
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=null){
            lengthA++;
            curA=curA.next;
        }
        while (curB!=null){
            lengthB++;
            curB=curB.next;
        }
        int dif=Math.abs(lengthA-lengthB);
        if(lengthA>lengthB) return getIntersectionNodeCore(headA,headB,dif);
        else return getIntersectionNodeCore(headB,headA,dif);
    }
    public ListNode getIntersectionNodeCore(ListNode fast,ListNode slow,int dif){
        while (dif!=0){
            fast=fast.next;
            dif--;
        }
        while (fast!=null&&slow!=null){
            if(fast==slow) return fast;
            fast=fast.next;
            slow=slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(1);
        node1.next=node2;

        ListNode node3=new ListNode(5);
        ListNode node4=new ListNode(0);
        ListNode node5=new ListNode(1);
        node3.next=node4;
        node4.next=node5;

        ListNode node6=new ListNode(8);
        ListNode node7=new ListNode(4);
        node2.next=node6;
        node5.next=node6;
        node6.next=node7;
        node7.next=null;
        System.out.println(solution.getIntersectionNode(node1,node3).val);
    }
}