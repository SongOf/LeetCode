package ex450;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.left==null&&root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else {
                TreeNode minNode=getMinNode(root.right);
                root.val=minNode.val;
                root.right=deleteNode(root.right,minNode.val);
            }

        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else {
            root.left=deleteNode(root.left,key);
        }
        return root;
    }
    public TreeNode getMinNode(TreeNode root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTCore(root,null,null);
    }
    public boolean isValidBSTCore(TreeNode root, TreeNode min, TreeNode max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.val<=min.val){
            return false;
        }
        if(max!=null&&root.val>=max.val){
            return false;
        }
        return isValidBSTCore(root.left,min,root)&&isValidBSTCore(root.right,root,max);
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
        TreeNode root=solution.deleteNode(node1,7);
        System.out.println(solution.isValidBST(root));
    }
}
