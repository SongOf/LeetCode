package ex143;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 15:39
 * @Version 1.0
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        LinkedList<ListNode> stack=new LinkedList<>();
        ListNode curNode=head;
        int length=0;
        while (curNode!=null){
            stack.push(curNode);
            length++;
            curNode=curNode.next;
        }
        curNode=head;
        for (int i = 1; i <= length/2; i++) {
            curNode=swap(curNode,curNode.next,stack.pop());
        }
        curNode.next=null;
    }
    public ListNode swap(ListNode curNode,ListNode nextNode,ListNode appendNode){
        curNode.next=appendNode;
        appendNode.next=nextNode;
        return nextNode;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        solution.reorderList(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
