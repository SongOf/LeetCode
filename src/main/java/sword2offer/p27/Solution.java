package sword2offer.p27;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        TreeNode temp=root.right;
        root.right=mirrorTree(root.left);
        root.left=mirrorTree(temp);
        return root;
    }
}
