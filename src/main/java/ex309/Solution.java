package ex309;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int pricesLength=prices.length;
        int dp_i_0=0;
        int dp_i2_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        int temp;
        for(int i=0;i<pricesLength;i++){
            temp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,dp_i2_0-prices[i]);
            dp_i2_0=temp;
        }
        return dp_i_0;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] prices={1,2,3,0,2};
        System.out.println(solution.maxProfit(prices));
    }
}
