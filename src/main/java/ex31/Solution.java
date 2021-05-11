package ex31;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/7 0:29
 * @Version 1.0
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int a = 0;
        int right = nums.length - 2;
        while (right >=0 && nums[right] >= nums[right+1]) {
            right--;
        }
       a = right;
        if(a >= 0) {
            right = nums.length - 1;
            while (right > a && nums[a] >= nums[right]) {
                right--;
            }
            swap(nums, a, right);
        }
        reverse(nums, a + 1, nums.length - 1);
    }
    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    public void reverse(int[] nums, int index1, int index2) {
        while (index1 < index2) {
            swap(nums, index1, index2);
            index1++;
            index2--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
