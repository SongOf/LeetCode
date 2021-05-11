package ex113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 1:04
 * @Version 1.0
 */
public class Solution {
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumCore(root, targetSum, path, res);
        return res;
    }
    public void pathSumCore(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if(root == null) return;
        sum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(path));
        }
        if(root.left != null) pathSumCore(root.left, targetSum, path, res);
        if(root.right != null) pathSumCore(root.right, targetSum, path, res);
        sum -= root.val;
        path.remove(path.size() - 1);
    }
}
