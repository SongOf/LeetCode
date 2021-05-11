package ex112;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/26 0:44
 * @Version 1.0
 */
public class Solution1 {
    public static class Node {
        TreeNode treeNode;
        int curSum;
        Node() {}
        Node(TreeNode treeNode, int curSum) {
            this.treeNode = treeNode;
            this.curSum = curSum;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, root.val));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if(curNode.treeNode.left == null && curNode.treeNode.right == null && curNode.curSum == targetSum) {
                return true;
            }
            if(curNode.treeNode.left != null) {
                queue.offer(new Node(curNode.treeNode.left, curNode.curSum + curNode.treeNode.left.val));
            }
            if(curNode.treeNode.right != null) {
                queue.offer(new Node(curNode.treeNode.right, curNode.curSum + curNode.treeNode.right.val));
            }
        }
        return false;
    }
}
