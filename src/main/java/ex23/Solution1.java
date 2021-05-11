package ex23;

import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description 优先级队列
 * @Date 2021/2/25 22:53
 * @Version 1.0
 */
public class Solution1 {
    public static class Status implements Comparable<Status> {
        private int val;
        private ListNode ptr;
        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status s1) {
            return this.val - s1.val;
        }
    }
    private PriorityQueue<Status> queue = new PriorityQueue<Status>();
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        if(lists == null || lists.length == 0)
            return head.next;
        for(ListNode node : lists) {
            if(node != null)
                queue.offer(new Status(node.val, node));
        }
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if(f.ptr.next != null)
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
        }
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
