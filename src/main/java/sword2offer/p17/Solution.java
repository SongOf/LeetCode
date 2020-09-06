package sword2offer.p17;

public class Solution {
    public int[] printNumbers(int n) {
        int len=pow(10,n);
        int[] res=new int[len-1];
        for(int i=1;i<len;i++){
            res[i-1]=i;
        }
        return res;
    }
    public int pow(int base,int exp){
        int res=1;
        while (exp>0){
            res*=base;
            exp--;
        }
        return res;
    }
}
