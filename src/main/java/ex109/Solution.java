package ex109;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/25 19:52
 * @Version 1.0
 */
public class Solution {
    private ListNode gHead;
    public TreeNode sortedListToBST(ListNode head) {
        gHead = head;
        int length = getLength(head);
        return sortedListToBSTCore(0, length - 1);
    }
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    public TreeNode sortedListToBSTCore(int left, int right) {
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode();
        root.left = sortedListToBSTCore(left, mid - 1);
        root.val = gHead.val;
        gHead = gHead.next;
        root.right = sortedListToBSTCore(mid + 1, right);
        return root;
    }
}
