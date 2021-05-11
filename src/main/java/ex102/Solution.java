package ex102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 23:22
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode cur = queue.poll();
                levelNodes.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            result.add(levelNodes);
        }
        return result;
    }
}
