package sword2offer.p13;

public class Solution {
    private int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int movingCount(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        return dfs(m, n, 0, 0, k, mark);
    }
    public int dfs(int m, int n, int row, int col, int k, boolean[][] mark) {
        if(row < 0 || row >= m || col < 0 || col >= n || mark[row][col] || isLarger(row, col, k)) return 0;
        mark[row][col] = true;
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dist[i][0];
            int newCol = col + dist[i][1];
            res = res + dfs(m, n, newRow, newCol, k, mark);
        }
        return res;
    }
    public boolean isLarger(int row, int col, int k) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum > k;
    }
}
