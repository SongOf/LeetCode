package sword2offer.p3;

import java.util.HashSet;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])) return nums[i];
            numSet.add(nums[i]);
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(nums));
    }
}
