package ex231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        n=n&(n-1);
        return n==0;
    }
}
