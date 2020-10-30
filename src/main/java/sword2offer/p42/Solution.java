package sword2offer.p42;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int max=nums[0];
        int curSum=nums[0];
        for(int i=1;i<len;i++){
            if(curSum<=0){
                curSum=nums[i];
            }else {
                curSum=curSum+nums[i];
            }
            if(curSum>max){
                max=curSum;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
