package ex112;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description DFS
 * @Date 2021/3/26 0:12
 * @Version 1.0
 */
public class Solution {
    private boolean hasPath;
    private int sum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        hasPath = false;
        sum = 0;
        hasPathSumCore(root, targetSum);
        return hasPath;
    }
    public void hasPathSumCore(TreeNode root, int targetSum) {
        if(hasPath) return;
        sum += root.val;
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                hasPath = true;
                return;
            }
        }
        if(root.left != null) hasPathSumCore(root.left, targetSum);
        if(root.right != null) hasPathSumCore(root.right, targetSum);
        sum -= root.val;
    }
}
