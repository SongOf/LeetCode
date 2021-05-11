package ex437;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/8 10:26
 * @Version 1.0
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return pathSumCore(root, prefixSumCount, sum, 0);
    }
    public int pathSumCore(TreeNode root, Map<Integer, Integer> prefixSumCount, int sum, int curSum) {
        if(root == null) return 0;
        curSum += root.val;
        int res = 0;
        res += prefixSumCount.getOrDefault(curSum - sum, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);
        res += pathSumCore(root.left, prefixSumCount, sum, curSum);
        res += pathSumCore(root.right, prefixSumCount, sum, curSum);
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return res;
    }
}
