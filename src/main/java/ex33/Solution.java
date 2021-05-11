package ex33;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/7 23:18
 * @Version 1.0
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null && nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid])
                    right = mid -1;
                else
                    left = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1};
        System.out.println(solution.search(nums, 1));
    }
}
