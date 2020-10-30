package ex122;
//解法二动态规划
public class Solution1 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int pricesLength=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for(int i=0;i<pricesLength;i++){
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,dp_i_0-prices[i]);
        }
        return dp_i_0;
    }
    public static void main(String[] args){
        Solution1 solution1=new Solution1();
        int[] prices={7,1,5,3,6,4};
        System.out.println(solution1.maxProfit(prices));
    }
}
