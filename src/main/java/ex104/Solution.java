package ex104;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 23:36
 * @Version 1.0
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
