package ex9;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x>=0 && x<=9){
            return true;
        }
        if(x<0 || x%10==0){
            return false;
        }
        int reverse=0;
        int tempX=x;
        while (tempX!=0){
            reverse=reverse*10+tempX%10;
            tempX=tempX/10;
        }
        return reverse==x;
    }
    public static void main(String[] args){
        int x =10;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}
