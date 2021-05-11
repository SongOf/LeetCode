package ex169;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/13 11:00
 * @Version 1.0
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0) candidate = nums[i];
            count += (candidate == nums[i] ? 1 : -1);
        }
        return candidate;
    }
}
