package ex114;

public class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=left;
        TreeNode curRoot=root;
        while (curRoot.right!=null){
            curRoot=curRoot.right;
        }
        curRoot.right=right;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node5=new TreeNode(5);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node5;
        node2.left=node3;
        node2.right=node4;
        node5.right=node6;
        solution.flatten(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.right;
        }
    }
}
