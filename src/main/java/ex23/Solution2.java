package ex23;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @author SongOf
 * @ClassName Solution2
 * @Description
 * @Date 2021/2/26 21:54
 * @Version 1.0
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r)
            return lists[l];
        else if(l > r)
            return null;
        int mid = (l + r) >> 1;
        return mergeList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    public ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null)
            return list1 != null ? list1 : list2;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return head.next;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        ListNode list3 = new ListNode(2);
        list2.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0]=list1;
        lists[1]=list2;
        lists[2]=list3;
        ListNode res = solution.mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
