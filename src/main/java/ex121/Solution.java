package ex121;
//解法一 转化成最大子序列和 剑指offer63
//解法二 动态规划
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        int pricesLength=prices.length;
        for(int i=0;i<pricesLength;i++){
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] prices={7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
