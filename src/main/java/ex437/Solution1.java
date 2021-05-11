package ex437;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/4/8 11:03
 * @Version 1.0
 */
public class Solution1 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return findPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int findPathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int tmp = 0;
        sum -= root.val;
        if(sum == 0) tmp ++;
        return tmp + findPathSum(root.left, sum) + findPathSum(root.right, sum);
    }
}
