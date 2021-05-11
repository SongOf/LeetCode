package ex698;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description K等分和
 * @Date 2021/4/8 0:37
 * @Version 1.0
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null) return false;
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if(sum % k != 0) return false;
        int tar = sum / k;
        boolean[] vis = new boolean[length];
        Arrays.fill(vis, false);
        return backTracing(nums, vis, k, tar, 0, 0);
    }
    public boolean backTracing(int[] nums, boolean[] vis, int k, int target, int cur, int index) {
        if(k == 1) return true;
        if(cur == target) return backTracing(nums, vis, k - 1, target, 0, 0);

        for (int i = index; i < nums.length; i++) {
            if(!vis[i] && cur + nums[i] <= target) {
                vis[i] = true;
                if(backTracing(nums, vis, k, target, cur + nums[i], i + 1)) return true;
                vis[i] = false;
            }
        }
        return false;
    }
}
