package ex322;
//递推
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }else if(amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        int coinsCate=coins.length;
        int dif;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coinsCate;j++){
                dif=i-coins[j];
                if(dif>=0&&dp[dif]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[dif]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    public static void main(String[] args){
        int[] coins={2};
        int  amount=3;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.coinChange(coins,amount));
    }
}
