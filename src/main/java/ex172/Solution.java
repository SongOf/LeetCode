package ex172;

public class Solution {
    public int trailingZeroes(int n) {
        if(n<5){
            return 0;
        }
        int res=0;
        for (int i = 5; i <= n; i=i*5) {
            res=res+n/i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.trailingZeroes(125));
    }
}