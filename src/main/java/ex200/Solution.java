package ex200;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description DFS
 * @Date 2021/3/13 20:08
 * @Version 1.0
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    islandNum++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandNum;
    }
    public void dfs(char[][] grid, int m, int n) {
        if(m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m - 1, n);
        dfs(grid, m + 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m, n + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
