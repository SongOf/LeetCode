package ex21;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/23 12:23
 * @Version 1.0
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val,ListNode next){this.val=val;this.next=next;}
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode preNode=head;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                preNode.next=l2;
                preNode=l2;
                l2=l2.next;
            }else {
                preNode.next=l1;
                preNode=l1;
                l1=l1.next;
            }
        }
        preNode.next=l1==null?l2:l1;
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode head1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(4);
        head1.next=node2;
        node2.next=node3;
        ListNode head2=new ListNode(1);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        head2.next=node4;
        node4.next=node5;
        head1=solution.mergeTwoLists(head1,head2);
        while (head1!=null){
            System.out.println(head1.val);
            head1=head1.next;
        }
    }
}
