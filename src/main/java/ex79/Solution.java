package ex79;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 0:01
 * @Version 1.0
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mark[i], false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(existCore(board, i, j, word, 0, mark)) return true;
            }
        }
        return false;
    }
    public boolean existCore(char[][] board, int i, int j, String word, int pos, boolean[][] mark) {
        if(board[i][j] != word.charAt(pos)) return false;
        else if(pos == word.length() - 1) return true;
        mark[i][j] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean result = false;
        for(int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if(newi >= 0 && newi < board.length && newj >=0 && newj < board[0].length && !mark[newi][newj]) {
                if(existCore(board, newi, newj, word, pos + 1, mark)) {
                    result = true;
                    break;
                }
            }
        }
        mark[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(solution.exist(board, "ABCB"));
    }
}
