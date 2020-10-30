package sword2offer.p55_1;

public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthCore(root);
    }
    public int maxDepthCore(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMaxDepth=maxDepthCore(root.left);
        int rightMaxDepth=maxDepthCore(root.right);
        return Math.max(leftMaxDepth+1,rightMaxDepth+1);
    }
    public static void main(String[] args){
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n2.left=null;
        n2.right=null;
        n3.left=n4;
        n3.right=n5;
        n4.left=null;
        n4.right=null;
        n5.left=null;
        n5.right=null;
        Solution solution=new Solution();
        System.out.println(solution.maxDepth(n1));
    }
}
