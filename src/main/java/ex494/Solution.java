package ex494;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/8 11:50
 * @Version 1.0
 */
public class Solution {
    private int res;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        findTargetSumWaysCore(nums, S, 0, 0);
        return res;
    }
    public void findTargetSumWaysCore(int[] nums, int S, int curSum, int index) {
        if(index == nums.length) {
            if(S == curSum) res ++;
            return;
        }
        findTargetSumWaysCore(nums, S, curSum + nums[index], index + 1);
        findTargetSumWaysCore(nums, S, curSum - nums[index], index + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
}
