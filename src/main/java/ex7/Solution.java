package ex7;

public class Solution {
    public int reverse(int x) {
        long res=0;
        while(x!=0){
            res=res*10+x%10;
            x=x/10;

        }
        if(res<=Integer.MAX_VALUE && res>=Integer.MIN_VALUE){
            return (int)res;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args){
        int x =Integer.MAX_VALUE;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }
}
