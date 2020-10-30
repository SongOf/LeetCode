package ex204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if(n<0){
            return -1;
        }else if(n<2){
            return 0;
        }
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j=j+i){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.countPrimes(10));
    }
}
