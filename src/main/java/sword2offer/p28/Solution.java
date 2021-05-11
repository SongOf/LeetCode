package sword2offer.p28;
//前序遍历和逆前序遍历
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }
    public boolean isSymmetricCore(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.val == root2.val && isSymmetricCore(root1.left, root2.right) && isSymmetricCore(root1.right, root2.left);
    }
}
