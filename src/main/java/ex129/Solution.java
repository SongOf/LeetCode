package ex129;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 2:02
 * @Version 1.0
 */
public class Solution {
    private int sum;
    private int num;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        num = 0;
        List<Integer> path = new ArrayList<>();
        sumNumbersCore(root, path);
        return sum;
    }
    public void sumNumbersCore(TreeNode root, List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        num = num * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += num;
        }
        if(root.left != null) sumNumbersCore(root.left, path);
        if(root.right != null) sumNumbersCore(root.right, path);
        path.remove(path.size() - 1);
        num = num / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.sumNumbers(root));
    }
}
