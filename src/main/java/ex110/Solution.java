package ex110;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/25 23:57
 * @Version 1.0
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean isBalance = Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1;
        return isBalance && isBalanced(root.left) && isBalanced(root.right);
    }
    public int treeHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
