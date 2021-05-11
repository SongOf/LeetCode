package ex24;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/28 15:09
 * @Version 1.0
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val=val; }
        ListNode(int val, ListNode next){ this.val=val;this.next=next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode preNode=new ListNode(-1,head);
        head=preNode;
        while (preNode.next!=null&&preNode.next.next!=null){
            preNode=swap(preNode,preNode.next,preNode.next.next);
        }
        return head.next;
    }
    public ListNode swap(ListNode preNode,ListNode curNode,ListNode nextNode){
        ListNode tail=nextNode.next;
        preNode.next=nextNode;
        nextNode.next=curNode;
        curNode.next=tail;
        return curNode;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node1=solution.swapPairs(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
