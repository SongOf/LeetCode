package ex130;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/26 12:28
 * @Version 1.0
 */
public class Solution1 {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public static class Loc {
        int row;
        int col;
        Loc() {}
        Loc(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        if(board == null || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        LinkedList<Loc> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O') queue.offer(new Loc(i, 0));
            if(board[i][n - 1] == 'O') queue.offer(new Loc(i, n - 1));
        }
        for (int i = 1; i < n; i++) {
            if(board[0][i] == 'O') queue.offer(new Loc(0, i));
            if(board[m - 1][i] == 'O') queue.offer(new Loc(m - 1, i));
        }
        while (!queue.isEmpty()) {
            Loc curLoc = queue.poll();
            board[curLoc.row][curLoc.col] = 'A';
            for (int i = 0; i < 4; i++) {
                int newRow = curLoc.row + dx[i];
                int newCol = curLoc.col + dy[i];
                if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || board[newRow][newCol] != 'O') continue;
                queue.push(new Loc(newRow, newCol));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'A') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solution.solve(board);
        System.out.println("helloo");
    }
}
