package ex23;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description 暴力解法
 * @Date 2020/11/28 14:55
 * @Version 1.0
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if(lists==null||lists.length==0){
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }
        return res;
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode curMergeNode = new ListNode();
        ListNode result = curMergeNode;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curMergeNode.next = list1;
                list1 = list1.next;
            }
            else {
                curMergeNode.next = list2;
                list2 = list2.next;
            }
            curMergeNode = curMergeNode.next;
        }
        if(list1 != null)
            curMergeNode.next = list1;
        if(list2 != null)
            curMergeNode.next = list2;
        return result.next;
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
