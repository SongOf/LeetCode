package ex199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 20:45
 * @Version 1.0
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
                if(i == size - 1) res.add(curNode.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.right = new TreeNode(5);
        node3.right = new TreeNode(4);
        System.out.println(solution.rightSideView(root));
    }
}
