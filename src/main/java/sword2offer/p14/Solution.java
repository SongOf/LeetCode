package sword2offer.p14;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/4/19 11:09
 * @Version 1.0
 */
public class Solution {
    public int cuttingRope(int n) {
        if(n < 2) return -1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
