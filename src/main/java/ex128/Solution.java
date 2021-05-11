package ex128;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 23:41
 * @Version 1.0
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i - 1] + 1 == nums[i]) {
                len++;
            }
            else if(nums[i - 1] != nums[i]){
                len = 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(solution.longestConsecutive(nums));
    }
}
