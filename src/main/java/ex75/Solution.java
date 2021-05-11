package ex75;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/11 0:37
 * @Version 1.0
 */
public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2--);
            }
            if(nums[i] == 0) {
                swap(nums, i, p0++);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
