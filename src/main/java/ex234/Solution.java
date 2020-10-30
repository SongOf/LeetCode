package ex234;

import java.util.LinkedList;
//利用栈
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        LinkedList<ListNode> stack=new LinkedList<>();
        ListNode curHead=head;
        while (curHead!=null){
            stack.push(curHead);
            curHead=curHead.next;
        }
        curHead=head;
        while (curHead!=null){
            if(curHead.val!=stack.pop().val){
                return false;
            }
            curHead=curHead.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        System.out.println(solution.isPalindrome(head));
    }
}
