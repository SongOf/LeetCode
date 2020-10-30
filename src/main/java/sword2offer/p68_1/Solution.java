package sword2offer.p68_1;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val>=p.val&&root.val<=q.val||root.val>=q.val&&root.val<=p.val){
            return root;
        }else if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return lowestCommonAncestor(root.left,p,q);
        }
    }
}
