package ex101;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 22:32
 * @Version 1.0
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }
    public boolean isSymmetricCore(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && isSymmetricCore(t1.left, t2.right) && isSymmetricCore(t1.right, t2.left);
    }
}
