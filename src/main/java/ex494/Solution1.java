package ex494;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/4/8 12:17
 * @Version 1.0
 */
public class Solution1 {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][- nums[0] + 1000] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if(dp[i - 1][j + 1000] > 0) {
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[n - 1][S + 1000];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
}
