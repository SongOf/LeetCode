package sword2offer.p14_;

public class Solution {
    public int cuttingRope(int n) {
        if(n < 4) {
            return n - 1;
        }else if(n == 4) {
            return n;
        }
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        // 最终剩下来的肯定是2,3,4
        return (int) (res * n % 1000000007);
    }
    public static void main(String[] args){
        int n=120;
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(n));
    }
}
