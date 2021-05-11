package ex19;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description 只遍历一次
 * @Date 2020/11/23 10:57
 * @Version 1.0
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy;
        ListNode fast=head;
        while (n>0){
            fast=fast.next;
            n--;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(2);
        head.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        ListNode node4=new ListNode(4);
        node3.next=node4;
        ListNode node5=new ListNode(5);
        node4.next=node5;
        node5.next=null;
        head=solution.removeNthFromEnd(head,2);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
