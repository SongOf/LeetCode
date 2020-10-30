package ex123;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int pricesLength=prices.length;
        int dp_i_0_k1=0;
        int dp_i_1_k1=Integer.MIN_VALUE;
        int dp_i_0_k2=0;
        int dp_i_1_k2=Integer.MIN_VALUE;
        for(int i=0;i<pricesLength;i++){
            dp_i_0_k1=Math.max(dp_i_0_k1,dp_i_1_k1+prices[i]);
            dp_i_1_k1=Math.max(dp_i_1_k1,-prices[i]);
            dp_i_0_k2=Math.max(dp_i_0_k2,dp_i_1_k2+prices[i]);
            dp_i_1_k2=Math.max(dp_i_1_k2,dp_i_0_k1-prices[i]);
        }
        return dp_i_0_k2;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] prices={7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }
}
