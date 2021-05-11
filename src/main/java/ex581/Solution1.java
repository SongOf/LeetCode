package ex581;

import java.util.Stack;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/4/10 10:31
 * @Version 1.0
 */
public class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length, right = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right > left ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
