package ex56;

import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/10 22:33
 * @Version 1.0
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < start) {
                merged.add(intervals[i]);
            }
            else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int T;
        T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                scanner.nextLine();
            }
            int[][] res = solution.merge(intervals);
            for (int j = 0; j < res.length; j++) {
                System.out.println(res[j][0] + " " + res[j][1]);
            }
        }
    }
}
