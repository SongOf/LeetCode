package sword2offer.p16;

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long exp = n;
        double res = 1.0;
        if(exp < 0) {
            exp = - exp;
            x = 1 / x;
        }
        while (exp > 0) {
            if((exp & 1) == 1) res *= x;
            x = x * x;
            exp = exp >> 1;
        }
        return res;
    }
    public static void main(String[] args){
        double x=2.00000;
        int n=-2147483648;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x,n));
    }
}
