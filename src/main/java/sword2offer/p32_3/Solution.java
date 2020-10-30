package sword2offer.p32_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> row=new ArrayList<Integer>();
        LinkedList<TreeNode> stack1=new LinkedList<TreeNode>();
        LinkedList<TreeNode> stack2=new LinkedList<TreeNode>();
        LinkedList<TreeNode> stackTemp=null;
        TreeNode curNode=null;
        stack1.push(root);
        int level=0;
        while (!stack1.isEmpty()){
            curNode=stack1.pop();
            row.add(curNode.val);
            if(level%2==1){
                if(curNode.right!=null){
                    stack2.push(curNode.right);
                }
                if(curNode.left!=null){
                    stack2.push(curNode.left);
                }
            }else {
                if(curNode.left!=null){
                    stack2.push(curNode.left);
                }
                if(curNode.right!=null){
                    stack2.push(curNode.right);
                }
            }
            if(stack1.isEmpty()){
                res.add(row);
                row=new ArrayList<Integer>();
                stackTemp=stack1;
                stack1=stack2;
                stack2=stackTemp;
                level++;
            }
        }
        return res;
    }
}
