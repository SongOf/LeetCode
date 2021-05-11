package ex215;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/14 16:15
 * @Version 1.0
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        int endIndex = nums.length - k;
        for (int i = len; i >= endIndex; i--) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
        return nums[endIndex];
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
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution1.findKthLargest(nums, 2));
    }
}
