package ex5693;

import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/20 22:31
 * @Version 1.0
 */
public class Solution {
    public int secondHighest(String s) {
        int[] nums = new int[20];
        Arrays.fill(nums, 0);
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] >= '0' && chs[i] <= '9') {
                nums[chs[i] - '0'] = 1;
            }
        }
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 1) count++;
            if(count == 2) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.secondHighest("ck077"));
    }
}
