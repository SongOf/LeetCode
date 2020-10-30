package ex124;

public class Solution {
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return -1;
        }
       maxPathSumCore(root);
        return maxSum;
    }
    public int maxPathSumCore(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,maxPathSumCore(root.left));
        int right=Math.max(0,maxPathSumCore(root.right));
        maxSum=Math.max(maxSum,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
