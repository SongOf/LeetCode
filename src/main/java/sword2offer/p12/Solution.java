package sword2offer.p12;

public class Solution {
    private int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        char[] words = word.toCharArray();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == words[0] && dfs(board, i, j, words, 0, mark)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int row, int col, char[] word, int index, boolean[][] mark) {
        if(index == word.length) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || mark[row][col] ||  word[index] != board[row][col]) return false;
        mark[row][col] = true;
        boolean res = false;
        for(int i = 0; i < 4; i++) {
            int newRow = row + dist[i][0];
            int newCol = col + dist[i][1];
            res = res || dfs(board, newRow, newCol, word, index + 1, mark);
        }
        mark[row][col] = false;
        return res;
    }
}
