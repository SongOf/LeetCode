package ex2;
//java为值传递 对象引用的copy值
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resListNode= new ListNode(0);
        resListNode.next=null;
        ListNode resListNodeTemp=resListNode;

        int carry=0;
        int temp=0;
        while (l1!=null && l2!=null){
            temp=l1.val+l2.val+carry;
            carry=temp/10;
            resListNode.next=new ListNode(temp%10);
            resListNode=resListNode.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            temp=l1.val+carry;
            resListNode.next=new ListNode(temp%10);
            carry=temp/10;
            resListNode=resListNode.next;
            l1=l1.next;
        }
        while (l2!=null){
            temp=l2.val+carry;
            resListNode.next=new ListNode(temp%10);
            carry=temp/10;
            resListNode=resListNode.next;
            l2=l2.next;
        }
        if(carry!=0){
            resListNode.next=new ListNode(carry);
            resListNode=resListNode.next;
        }
        resListNode.next=null;
        return resListNodeTemp.next;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        ListNode l1= new ListNode(5);
        ListNode l1x=l1;
//        l1.next=new ListNode(4);
//        l1=l1.next;
//        l1.next=new ListNode(3);
//        l1=l1.next;
        l1.next=null;
        ListNode l2= new ListNode(5);
        ListNode l2x=l2;
//        l2.next=new ListNode(6);
//        l2=l2.next;
//        l2.next=new ListNode(4);
//        l2=l2.next;
        l2.next=null;
        ListNode l1Print=l1x;
        while (l1Print!=null){
            System.out.println(l1Print.val);
            l1Print=l1Print.next;
        }
        System.out.println("----------------------------");
        ListNode l2Print=l2x;
        while (l2Print!=null){
            System.out.println(l2Print.val);
            l2Print=l2Print.next;
        }
        System.out.println("----------------------------");
        ListNode res=solution.addTwoNumbers(l1x,l2x);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
