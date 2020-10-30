package ex283;

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int len=nums.length;
        int slow=0,fast=0;
        while (fast<len){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow<len){
            nums[slow]=0;
            slow++;
        }
    }
}