package ex213;

public class Solution {
    public int rob(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robCore(nums,0,nums.length-2),robCore(nums,1,nums.length-1));
    }
    public int robCore(int[] nums,int start,int end){
        int dp_0=0;
        int dp_1=0;
        int dp_2=0;
        for(int i=end;i>=start;i--){
            dp_0=Math.max(dp_1,nums[i]+dp_2);
            dp_2=dp_1;
            dp_1=dp_0;
        }
        return dp_0;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums={1,2,3,1};
        System.out.println(solution.rob(nums));
    }
}
