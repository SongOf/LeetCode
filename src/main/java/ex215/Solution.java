package ex215;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/14 15:13
 * @Version 1.0
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int tarIndex = nums.length - k;
        return findKthLargestCore(nums, 0, nums.length - 1, tarIndex);
    }
    public int findKthLargestCore(int[] nums, int low, int high, int tarIndex) {
        if (low < high) {
            int index = partition(nums, low, high);
            if(index == tarIndex) {
                return nums[index];
            }
            else if(index < tarIndex) {
                return findKthLargestCore(nums, index + 1, high, tarIndex);
            }
            else {
                return findKthLargestCore(nums, low, index - 1, tarIndex);
            }
        }
        return nums[tarIndex];
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));
    }
}
