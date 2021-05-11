package ex108;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/25 19:29
 * @Version 1.0
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBSTCore(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore(nums, left, mid -1);
        root.right = sortedArrayToBSTCore(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(nums);
        solution.printTree(root);
    }
    public void printTree(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
