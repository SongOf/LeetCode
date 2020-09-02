package sword2offer.p14;

public class Solution {
    public int cuttingRope(int n) {
        if(n<2){
            return 0;
        }else if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int max=0;
        int temp=0;
        for(int i=4;i<=n;i++){
            max=0;
            for(int j=1;j<=i/2;j++){
                temp=dp[j]*dp[i-j];
                if(max<temp){
                    max=temp;
                }
            }
            dp[i]=max;
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=10;
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(n));
    }
}
