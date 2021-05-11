package ex0;

/**
 * @author SongOf
 * @ClassName Solution2
 * @Description
 * @Date 2021/3/14 15:54
 * @Version 1.0
 */
public class Solution2 {
    public int[] sortArray(int[] nums) {
        if(nums == null) return null;
        heapSort(nums);
        return nums;
    }
    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; i--) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }
    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }
    public void maxHeapify(int[] nums, int root, int len) {
        while ((root << 1) + 1 <= len) {
            int lson = (root << 1) + 1;
            int rson = (root << 1) + 2;
            int large = root;
            if(lson <= len && nums[lson] > nums[large]) {
                large = lson;
            }
            if(rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if(large != root) {
                swap(nums, root, large);
                root = large;
            }
            else {
                break;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
