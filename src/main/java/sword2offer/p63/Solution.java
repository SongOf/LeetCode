package sword2offer.p63;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int len=prices.length;
        int diffPrices;
        int maxProfit=0;
        int curMaxProfit=0;
        for(int i=1;i<len;i++){
            diffPrices=prices[i]-prices[i-1];
            curMaxProfit=curMaxProfit+diffPrices;
            if(curMaxProfit<0){
                curMaxProfit=0;
            }
            if(maxProfit<curMaxProfit){
                maxProfit=curMaxProfit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] prices={7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }
}
