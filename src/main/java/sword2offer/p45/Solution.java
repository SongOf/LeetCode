package sword2offer.p45;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/6/16 22:14
 * @Version 1.0
 */
public class Solution {
    public String minNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsStr.length; i++) {
            sb.append(numsStr[i]);
        }
        return sb.toString();
    }
}
