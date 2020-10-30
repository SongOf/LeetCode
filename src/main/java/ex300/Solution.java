package ex300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length;
        int[] dp=new int[length];
        for(int i=0;i<length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
