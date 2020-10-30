package sword2offer.p32;

import java.util.*;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> res=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode curNode=null;
        queue.add(root);
        while (!queue.isEmpty()){
            curNode=queue.poll();
            res.add(curNode.val);
            if(curNode.left!=null){
                queue.add(curNode.left);
            }
            if(curNode.right!=null){
                queue.add(curNode.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
