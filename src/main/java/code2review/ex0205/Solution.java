package code2review.ex0205;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/5/10 11:40
 * @Version 1.0
 */
public class Solution {
    //反向存储
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int l1Len = getListLength(l1);
        int l2Len = getListLength(l2);
        if(l1Len > l2Len) return addTwoNumbersCore(l1, l2);
        else return addTwoNumbersCore(l2, l1);
    }
    //正向存储
    public ListNode addAB(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        int l1Len = getListLength(l1);
        int l2Len = getListLength(l2);
        if(l1Len > l2Len) return addTwoNumbersCore(l1, l2);
        else return addTwoNumbersCore(l2, l1);
    }
    public int getListLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len ++;
            l = l.next;
        }
        return len;
    }
    public ListNode reverse(ListNode l) {
        ListNode pre = null;
        while (l != null) {
            ListNode nxt = l.next;
            l.next = pre;
            pre = l;
            l = nxt;
        }
        return pre;
    }
    public ListNode addTwoNumbersCore(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int c = 0;
        int sum;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            sum = c + l1.val + l2.val;
            c = sum / 10;
            l1.val = sum % 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = c + l1.val;
            c = sum / 10;
            l1.val = sum % 10;
            pre = l1;
            l1 = l1.next;
        }
        if(c != 0) {
            pre.next = new ListNode(c);
        }
        return head;
    }
}
