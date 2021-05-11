package sword2offer.p13;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description BFS
 * @Date 2021/4/16 16:32
 * @Version 1.0
 */
public class Solution1 {
    private static final int[][] dist = {{1, 0}, {0, 1}};
    public static class Node {
        private int row;
        private int col;
        public Node() {}
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        int res = 1;
        mark[0][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 2; i++) {
                int newRow = cur.row + dist[i][0];
                int newCol = cur.col + dist[i][1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !mark[newRow][newCol] && !isLarger(newRow, newCol, k)) {
                    queue.offer(new Node(newRow, newCol));
                    res ++;
                    mark[newRow][newCol] = true;
                }
            }
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
