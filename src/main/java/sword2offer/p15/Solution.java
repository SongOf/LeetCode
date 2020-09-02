package sword2offer.p15;

public class Solution {
    public int cuttingRope(int n) {
        if(n<2){
            return 0;
        }else if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        long res=1;
        while (n>=5){
            res=res*3%1000000007;
            n=n-3;
        }
        return (int)(res*n%1000000007);
    }
    public static void main(String[] args){
        int n=120;
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(n));
    }
}
