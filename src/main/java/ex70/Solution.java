package ex70;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/11 0:27
 * @Version 1.0
 */
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}
