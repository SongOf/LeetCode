package ex27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int slow=0,fast=0;
        while (fast<len){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={4,2};
        System.out.println(solution.removeElement(nums,2));
    }
}
