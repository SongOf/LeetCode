package ex238;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/20 11:46
 * @Version 1.0
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right *  nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int[] res = solution.productExceptSelf(nums);
        for (int item : res) {
            System.out.println(item);
        }
    }
}
