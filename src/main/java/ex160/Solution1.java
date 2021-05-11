package ex160;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2020/12/5 16:53
 * @Version 1.0
 */
public class Solution1 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA==null||headB==null) return null;
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=curB){
            curA= curA==null?headB:curA.next;
            curB= curB==null?headA:curB.next;
        }
        return curA;
    }
}