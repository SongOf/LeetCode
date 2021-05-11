package ex143;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 15:39
 * @Version 1.0
 */
public class Solution1 {
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
        ListNode headPre=new ListNode(-1,head);
        ListNode midNode=findMiddle(headPre);
        ListNode head1=headPre.next;
        ListNode head2=midNode.next;
        midNode.next=null;
        head2=reverseList(head2);
        mergeList(head1,head2);
    }
    public ListNode findMiddle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode preNode=null;
        ListNode nextNode;
        while (head!=null){
            nextNode=head.next;
            head.next=preNode;
            preNode=head;
            head=nextNode;
        }
        return preNode;
    }
    public ListNode mergeList(ListNode head1,ListNode head2){
        ListNode head=new ListNode(-1,head1);
        ListNode curNode=head;
        while (head1!=null&&head2!=null){
            curNode.next=head1;
            head1=head1.next;
            curNode=curNode.next;
            curNode.next=head2;
            head2=head2.next;
            curNode=curNode.next;
        }
        curNode.next=head1==null?head2:head1;
        return head.next;
    }

    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
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
//        ListNode temp=solution1.findMiddle(node2);
//        System.out.println("mid"+temp.val);
//        ListNode temp2=solution1.reverseList(node2);
//        while (temp2!=null){
//            System.out.println(temp2.val);
//            temp2=temp2.next;
//        }
//        ListNode node11=new ListNode(7);
//        ListNode node12=new ListNode(8);
//        node11.next=node12;
//        node12.next=null;
//        ListNode node21=new ListNode(9);
//        node21.next=null;
//        ListNode temp3=solution1.mergeList(node11,node21);
//        while (temp3!=null){
//            System.out.println(temp3.val);
//            temp3=temp3.next;
//        }
        solution1.reorderList(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
