package ex239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/14 17:57
 * @Version 1.0
 */
public class Solution {
    public static class Num implements Comparable<Num>{
        public int val;
        public int index;
        public Num() {}
        public Num(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Num o) {
            return o.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Num> queue = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            queue.offer(new Num(nums[i], i));
        }
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            queue.offer(new Num(nums[right], right));
            Num maxNum = queue.poll();
            while (maxNum.index < left) {
                maxNum = queue.poll();
            }
            res.add(maxNum.val);
            left++;
            right++;
            if(maxNum.index >= left) {
                queue.offer(maxNum);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = solution.maxSlidingWindow(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
