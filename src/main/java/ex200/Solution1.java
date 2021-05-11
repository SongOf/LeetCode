package ex200;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/13 22:25
 * @Version 1.0
 */
public class Solution1 {
    public static class Node {
        private int i;
        private int j;
        public Node(){}
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandNum = 0;
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    islandNum++;
                    grid[i][j] = '0';
                    queue.offer(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();
                        if(cur.i - 1 >= 0 && grid[cur.i - 1][cur.j] == '1') {
                            grid[cur.i - 1][cur.j] = '0';
                            queue.offer(new Node(cur.i - 1, cur.j));
                        }
                        if(cur.i + 1 < m && grid[cur.i + 1][cur.j] == '1') {
                            grid[cur.i + 1][cur.j] = '0';
                            queue.offer(new Node(cur.i + 1, cur.j));
                        }
                        if(cur.j - 1 >= 0 && grid[cur.i][cur.j - 1] == '1') {
                            grid[cur.i][cur.j - 1] = '0';
                            queue.offer(new Node(cur.i, cur.j - 1));
                        }
                        if(cur.j + 1 < n && grid[cur.i][cur.j + 1] == '1') {
                            grid[cur.i][cur.j + 1] = '0';
                            queue.offer(new Node(cur.i, cur.j + 1));
                        }
                    }
                }
            }
        }
        return islandNum;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solution1.numIslands(grid));
    }
}
