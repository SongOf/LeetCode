package ex111;

import java.util.LinkedList;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        int minLevel=1;
        TreeNode curNode;
        queue.addLast(root);
        int rowLen;
        while (!queue.isEmpty()){
            rowLen=queue.size();
            for(int i=0;i<rowLen;i++){
                curNode=queue.removeFirst();
                if(curNode.left==null&&curNode.right==null){
                    return minLevel;
                }
                if(curNode.left!=null){
                    queue.addLast(curNode.left);
                }
                if(curNode.right!=null){
                    queue.addLast(curNode.right);
                }
            }
            minLevel++;
        }
        return minLevel;
    }
}
