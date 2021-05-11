package ex53;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/9 22:10
 * @Version 1.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > maxSum) maxSum = sum;
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-100000};
        System.out.println(solution.maxSubArray(nums));
    }
}
