package ex279;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/22 10:19
 * @Version 1.0
 */
public class Solution {
    public int numSquares(int n) {
        int sqrtNum = (int) Math.sqrt(n);
        int[] nums = new int[sqrtNum + 1];
        for (int i = 0; i <= sqrtNum; i++) {
            nums[i] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sqrtNum && i >= nums[j]; j++) {
                dp[i] = Math.min(dp[i], dp[i - nums[j]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(13));
    }
}
