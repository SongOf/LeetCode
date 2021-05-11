package ex55;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/9 23:23
 * @Version 1.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        Arrays.fill(mark, false);
        mark[0] = true;
        return canJumpCore(nums, 0, mark);
    }
    public boolean canJumpCore(int[] nums, int loc, boolean[] mark) {
        if(loc == nums.length - 1) {
            return true;
        }
        if(loc >= nums.length) return false;
        boolean res = false;
        for (int i = 1; loc + i < nums.length && i <= nums[loc]; i++) {
            if(!mark[loc + i]) {
                mark[loc + i] = true;
                res = res | canJumpCore(nums, loc + i, mark);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,0};
        System.out.println(solution.canJump(nums));
    }
}
