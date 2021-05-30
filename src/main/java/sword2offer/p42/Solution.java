package sword2offer.p42;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int dp = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < length; i++) {
            if(dp > 0) dp = dp + nums[i];
            else dp = nums[i];
            if(dp > maxSum) maxSum = dp;
        }
        return maxSum;
    }
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < length; i++) {
            if(dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
            else dp[i] = nums[i];
            if(dp[i] > maxSum) maxSum = dp[i];
        }
        return maxSum;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
