package ex5561;

import java.util.Map;

public class Solution {
    public int getMaximumGenerated(int n) {
        int[] result=new int[n+1];
        generatedCore(n,result);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n+1; i++) {
            max= Math.max(max,result[i]);
        }
        return max;
    }
    public void generatedCore(int n,int[] result){
        result[0]=0;
        if(n>0){
            result[1]=1;
        }
        if(n>=2){
            for (int i = 1;2*i <=n&&(2*i+1)<=n;i++) {
                result[2*i]=result[i];
                result[2*i+1]=result[i]+result[i+1];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.getMaximumGenerated(11));
    }
}
