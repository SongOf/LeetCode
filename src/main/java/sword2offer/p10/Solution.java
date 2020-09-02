package sword2offer.p10;

public class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int[] fib=new int[n+1];
        fib[0]=0;
        fib[1]=1;
        long sum=0;
        for(int i=2;i<=n;i++){
            sum=fib[i-1]+fib[i-2];
            fib[i]=(int)(sum%1000000007);
        }
        return fib[n];
    }
    public static void main(String[] args){
        int n=5;
        Solution solution = new Solution();
        System.out.println(solution.fib(n));
    }
}
