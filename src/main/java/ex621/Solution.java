package ex621;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/10 13:48
 * @Version 1.0
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        Arrays.fill(taskCount, 0);
        for (int i = 0; i < tasks.length; i++) {
            taskCount[tasks[i] - 'A'] ++;
        }
        Arrays.sort(taskCount);
        int maxTimes = taskCount[25];
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if(taskCount[i + 1] == taskCount[i]) {
                maxCount ++;
            }
            else break;
        }
        int ans = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(ans, tasks.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(solution.leastInterval(tasks, 2));
    }
}
