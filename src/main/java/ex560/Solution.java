package ex560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/9 10:58
 * @Version 1.0
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null) return 0;
        int n = nums.length;
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(pre, 1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if(preMap.containsKey(pre - k)) {
                count += preMap.get(pre - k);
            }
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        System.out.println(solution.subarraySum(nums, 2));
    }
}