package ex234;

public class Solution1 {
    public boolean isPalindrome(ListNode head){
        if(head==null){
            return true;
        }
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode list1=head;
        ListNode list2=reverse(slow);
        while (list2!=null){
            if(list1.val!=list2.val){
                return false;
            }
            list1=list1.next;
            list2=list2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode curNode=head;
        while (curNode!=null){
            ListNode nextNode=curNode.next;
            curNode.next=pre;
            pre=curNode;
            curNode=nextNode;
        }
        return pre;
    }
    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        System.out.println(solution1.isPalindrome(head));
    }
}
