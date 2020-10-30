package ex98;

import java.util.LinkedList;

//用栈的形式中序遍历二叉树 判断是否是增序
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode curRoot=root;
        LinkedList<TreeNode> stack=new LinkedList<>();
        long pre=Long.MIN_VALUE;
        while (!stack.isEmpty()||curRoot!=null){
            while (curRoot!=null){
                stack.push(curRoot);
                curRoot=curRoot.left;
            }
            curRoot=stack.pop();
            if(curRoot.val<=pre){
                return false;
            }
            pre=curRoot.val;
            curRoot=curRoot.right;
        }
        return true;
    }
}
