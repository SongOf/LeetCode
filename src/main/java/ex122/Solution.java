package ex122;
//解法一 差值序列的所有正元素的和
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int pricesLength=prices.length;
        int dif;
        int maxPro=0;
        for(int i=1;i<pricesLength;i++){
            dif=prices[i]-prices[i-1];
            if(dif>0){
                maxPro=maxPro+dif;
            }
        }
        return maxPro;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] prices={7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
