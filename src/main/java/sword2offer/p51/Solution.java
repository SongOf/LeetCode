package sword2offer.p51;

public class Solution {
    private int res;
    public int reversePairs(int[] nums) {
        res = 0;
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }
    public void mergeSort(int[] nums, int start, int end) {
        int mid = start + ((end - start) >> 1);
        if (start < end) {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }
    public void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int cur = 0;
        int leftPos = start, rightPos = mid + 1;

        while (leftPos <= mid && rightPos <= end) {
            if (nums[leftPos] <= nums[rightPos]) {
                tmp[cur++] = nums[leftPos++];
            } else {
                //用来统计逆序对的个数
                res += (mid - leftPos + 1);
                tmp[cur++] = nums[rightPos++];
            }
        }
        while (leftPos <= mid) {
            tmp[cur++] = nums[leftPos++];
        }
        while (rightPos <= end) {
            tmp[cur++] = nums[rightPos++];
        }
        for (int k = 0; k < tmp.length; k++) {
            nums[k + start] = tmp[k];
        }
    }
}
