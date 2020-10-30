package ex198;

public class Solution1 {
    public int rob(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int numsLength=nums.length;
        int dp_0=0;
        int dp_1=0;
        int dp_2=0;
        for(int i=numsLength-1;i>=0;i--){
            dp_0=Math.max(dp_1,nums[i]+dp_2);
            dp_2=dp_1;
            dp_1=dp_0;
        }
        return dp_0;
    }
    public static void main(String[] args){
        Solution1 solution1=new Solution1();
        int[] nums={2,7,9,3,1};
        System.out.println(solution1.rob(nums));
    }
}
