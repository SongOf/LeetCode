package ex322;
//记忆化搜索
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount<0){
            return -1;
        }else if (amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        return coinChangeCore(coins,amount,dp);
    }
    public int coinChangeCore(int[] coins, int amount,int[] dp){
        if (amount<0){
            return -1;
        }else if (amount==0){
            return 0;
        }
        if(dp[amount]!=Integer.MAX_VALUE){
            return dp[amount];
        }
        int len=coins.length;
        int sub;
        int curMin=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            sub=coinChangeCore(coins,amount-coins[i],dp);
            if(sub!=-1){
                curMin=Math.min(curMin,1+sub);
            }
        }
        dp[amount]=curMin==Integer.MAX_VALUE?-1:curMin;
        return dp[amount];
    }
    public static void main(String[] args){
        int[] coins={186,419,83,408};
        int  amount=6249;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins,amount));
    }
}
