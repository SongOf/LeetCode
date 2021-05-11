package ex5709;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/21 10:30
 * @Version 1.0
 */
public class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int curMax = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > curMax) {
                curMax = nums[i];
                curSum += nums[i];
                maxSum = Math.max(maxSum, curSum);
            }
            else {
                curMax = nums[i];
                curSum = nums[i];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100,10,1};
        System.out.println(solution.maxAscendingSum(nums));
    }
}
