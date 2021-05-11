package ex64;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/10 23:55
 * @Version 1.0
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
       int T = scanner.nextInt();
       scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] grid = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = scanner.nextInt();
                }
                scanner.nextLine();
            }
            System.out.println(solution.minPathSum(grid));
        }
    }
}
