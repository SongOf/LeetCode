package ex147;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/12/5 13:46
 * @Version 1.0
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode lastSorted=head;
        ListNode curNode=head.next;
        while (curNode!=null){
            if(lastSorted.val<=curNode.val){ //当前值大于最后一个有序元素
                lastSorted=lastSorted.next;
            }else { //最后一个有序元素一定大于当前值 找到第一个大于当前值的有序元素
                ListNode prev=dummyHead;
                while (prev.next.val<=curNode.val){
                    prev=prev.next;
                }
                lastSorted.next=curNode.next;
                curNode.next=prev.next;
                prev.next=curNode;
            }
            curNode=lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        node1=solution.insertionSortList(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
