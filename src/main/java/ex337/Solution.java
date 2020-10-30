package ex337;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<TreeNode,Integer> remember=new HashMap<>();
    public int rob(TreeNode root) {
        return robCore(root);
    }
    public int robCore(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(remember.containsKey(root)){
            return remember.get(root);
        }
        int rob=root.val;
        if(root.left!=null){
            rob=rob+robCore(root.left.left)+robCore(root.left.right);
        }
        if(root.right!=null){
            rob=rob+robCore(root.right.left)+robCore(root.right.right);
        }
        int notRob=robCore(root.left)+robCore(root.right);
        int res=Math.max(rob,notRob);
        remember.put(root,res);
        return res;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=null;
        node2.right=node4;
        node4.left=null;
        node4.right=null;
        node3.left=null;
        node3.right=node5;
        node5.left=null;
        node5.right=null;
        System.out.println(solution.rob(node1));
    }
}
