package sword2offer.p55_2;

public class Solution1 {
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        return isBalancedCore(root)!=-1;
    }
    public int isBalancedCore(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=isBalancedCore(root.left);
        if(left==-1){
            return -1;
        }
        int right=isBalancedCore(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)<=1){
            return Math.max(left,right)+1;
        }else {
            return -1;
        }
    }
}