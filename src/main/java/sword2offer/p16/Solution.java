package sword2offer.p16;

public class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0000;
        }else if(n==1){
            return x;
        }
        int exp=n>=0?n:-n;
        double[] res=new double[exp+1];
        res[0]=1.0;
        res[1]=x;
        for(int i=2;i<=exp;i=i*2){
            res[i]=res[i/2]*res[i/2]*(i-i/2*2);
        }
        return n>=0?res[exp]:1/res[exp];
    }
    public static void main(String[] args){
        double x=2.00000;
        int n=-2;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x,n));
    }
}
