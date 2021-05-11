package ex55;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/9 23:59
 * @Version 1.0
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        int rightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i <= rightMax) {
                rightMax = Math.max(rightMax, i + nums[i]);
                if(rightMax >= nums.length - 1) return true;
            }
        }
        return false;
    }
}
