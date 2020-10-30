package ex673;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length;
        int[] dp=new int[length];
        int[] counter=new int[length];
        for(int i=0;i<length;i++){
            dp[i]=1;
            counter[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        counter[i]=counter[j];
                    }else if(dp[i]==dp[j]+1){
                        counter[i]=counter[i]+counter[j];
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<length;i++){
            max=Math.max(max,dp[i]);
        }
        int res=0;
        for(int i=length-1;i>=0;i--){
            if(max==dp[i]){
                res+=counter[i];
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={2,2,2,2,2};
        System.out.println(solution.findNumberOfLIS(nums));
    }
}
