package ex701;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val==val){
            return root;
        }else if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else {
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(7);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=null;
        node3.right=null;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        TreeNode root=solution.insertIntoBST(node1,5);
        System.out.println(node3.left.val);
    }
}
