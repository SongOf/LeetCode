package ex103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 20:13
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                levelNodes.add(curNode.val);
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            res.add(levelNodes);
        }
        for (int i = 0; i < res.size(); i++) {
            if(i % 2 == 1) Collections.reverse(res.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = new TreeNode(15);
        node2.right = new TreeNode(7);
        System.out.println(solution.zigzagLevelOrder(root));
    }
}
