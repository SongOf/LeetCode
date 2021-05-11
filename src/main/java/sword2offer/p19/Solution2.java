package sword2offer.p19;

import java.util.Random;

/**
 * @author SongOf
 * @ClassName Solution2
 * @Description
 * @Date 2021/4/22 11:14
 * @Version 1.0
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    public int getRandom() {
        int k = 1;
        Random random = new Random();
        while (random.nextBoolean() && k < Integer.MAX_VALUE) {
            k ++;
        }
        return k;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isMatch("mississippi", "mis*is*p*."));
        System.out.println(solution2.getRandom());
    }
}
