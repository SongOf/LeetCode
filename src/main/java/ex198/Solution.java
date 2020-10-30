package ex198;
//记忆化搜索的动态规划实现
public class Solution {
    private int[] remember;
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        remember=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            remember[i]=-1;
        }
        return robCore(nums,0);
    }
    public int robCore(int[] nums,int n){
        int numsLength=nums.length;
        if(n>=numsLength){
            return 0;
        }
        if(remember[n]!=-1){
            return remember[n];
        }else {
            int maxRob=Math.max(robCore(nums,n+1),robCore(nums,n+2)+nums[n]);
            remember[n]=maxRob;
            return maxRob;
        }
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums={2,7,9,3,1};
        System.out.println(solution.rob(nums));
    }
}
