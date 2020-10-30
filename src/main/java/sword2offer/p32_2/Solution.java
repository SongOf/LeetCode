package sword2offer.p32_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        int curRowNums=0;
        int nextRowNums=0;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> row=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode curNode=null;
        queue.add(root);
        curRowNums=1;
        while (!queue.isEmpty()){
            curNode=queue.poll();
            row.add(curNode.val);
            if(curNode.left!=null){
                queue.add(curNode.left);
                nextRowNums++;
            }
            if(curNode.right!=null){
                queue.add(curNode.right);
                nextRowNums++;
            }
            curRowNums--;
            if(curRowNums==0){
                res.add(row);
                row=new ArrayList<Integer>();
                curRowNums=nextRowNums;
                nextRowNums=0;
            }
        }
        return res;
    }
}
