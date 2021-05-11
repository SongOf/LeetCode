package ex0;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description 快速排序
 * @Date 2021/3/14 15:24
 * @Version 1.0
 */
public class Solution1 {
    public int[] sortArray(int[] nums) {
        if(nums == null) return null;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int index = partition(nums, low, high);
            quickSort(nums, low, index -1);
            quickSort(nums, index + 1, high);
        }
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
}
