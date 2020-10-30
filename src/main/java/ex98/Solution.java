package ex98;

//先序遍历+增加参数列表
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTCore(root,null,null);
    }
    public boolean isValidBSTCore(TreeNode root,TreeNode min,TreeNode max){
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
}
