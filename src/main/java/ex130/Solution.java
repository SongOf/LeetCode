package ex130;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 11:46
 * @Version 1.0
 */
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'A') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'A';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'O','O'},
                {'O','O'},
        };
        solution.solve(board);
        System.out.println("hello");
    }
}
