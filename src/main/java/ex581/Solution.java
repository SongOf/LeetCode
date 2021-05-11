package ex581;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/9 11:51
 * @Version 1.0
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            minQueue.offer(nums[i]);
            maxQueue.offer(nums[i]);
        }
        int start = 0;
        while (start < n && !minQueue.isEmpty() && nums[start] == minQueue.poll()) {
            start ++;
        }
        int end = n -1;
        while (end >= 0 && !maxQueue.isEmpty() && nums[end] == maxQueue.poll()) {
            end --;
        }
        if(end > start)
            return end - start + 1;
        else return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
