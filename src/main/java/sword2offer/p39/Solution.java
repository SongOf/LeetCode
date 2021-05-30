package sword2offer.p39;

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null) return -1;

        int tar = -1;
        int frequency = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(frequency == 0) tar = nums[i];
            if(tar == nums[i]) frequency ++;
            else frequency --;
        }
        return tar;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.majorityElement(nums));
    }
}
