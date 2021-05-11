package ex287;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/22 11:00
 * @Version 1.0
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println(solution.findDuplicate(nums));
    }
}
