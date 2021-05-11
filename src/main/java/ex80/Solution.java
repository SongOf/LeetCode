package ex80;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/28 15:45
 * @Version 1.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[i - 1]) {
                count ++;
            }
            else {
                count = 1;
            }
            if(count <= 2) {
                nums[j ++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
    }
}
