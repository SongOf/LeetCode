package ex416;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description 2等分和
 * @Date 2021/4/6 11:32
 * @Version 1.0
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(j - nums[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 3, 3, 4, 5};
        System.out.println(solution.canPartition(nums));
    }

}
