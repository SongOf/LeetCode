package ex26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int slow=0,fast=0;
        while (fast<len){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1,2};
        System.out.println(solution.removeDuplicates(nums));
    }
}
