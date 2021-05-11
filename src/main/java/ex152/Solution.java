package ex152;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/13 19:33
 * @Version 1.0
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxP = nums[0];
        int minP = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTmp = maxP;
            int minTmp = minP;
            maxP = Math.max(maxTmp * nums[i], Math.max(minTmp * nums[i], nums[i]));
            minP = Math.min(maxTmp * nums[i], Math.min(minTmp * nums[i], nums[i]));
            res = Math.max(res, maxP);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4,-3,-2};
        System.out.println(solution.maxProduct(nums));
    }
}
