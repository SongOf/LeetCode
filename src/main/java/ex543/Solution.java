package ex543;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/9 10:35
 * @Version 1.0
 */
public class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        diameterOfBinaryTreeCore(root);
        return max;
    }
    public int diameterOfBinaryTreeCore(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = diameterOfBinaryTreeCore(root.left);
        int rightHeight = diameterOfBinaryTreeCore(root.right);
        max = Math.max(max, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
