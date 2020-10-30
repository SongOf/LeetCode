package ex188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int pricesLength=prices.length;
        if(k>pricesLength/2){
            return maxProfitWithoutK(prices);
        }
        int[][][] dp=new int[pricesLength][k+1][2];
        for(int i=0;i<pricesLength;i++){
            dp[i][0][0]=0;
            dp[i][0][1]=Integer.MIN_VALUE;
        }
        for(int mk=1;mk<=k;mk++){
            for (int i=0;i<pricesLength;i++){
                if(i==0){
                    dp[i][mk][0]=Math.max(0,Integer.MIN_VALUE+prices[i]);
                    dp[i][mk][1]=Math.max(Integer.MIN_VALUE,-prices[i]);
                }else {
                    dp[i][mk][0]=Math.max(dp[i-1][mk][0],dp[i-1][mk][1]+prices[i]);
                    dp[i][mk][1]=Math.max(dp[i-1][mk][1],dp[i-1][mk-1][0]-prices[i]);
                }
            }
        }
        return dp[pricesLength-1][k][0];
    }
    public int maxProfitWithoutK(int[] prices) {
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
        Solution solution=new Solution();
        int[] prices={3,2,6,5,0,3};
        System.out.println(solution.maxProfit(2,prices));
    }
}

