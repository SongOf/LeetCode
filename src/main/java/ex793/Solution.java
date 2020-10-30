package ex793;

public class Solution {
    public int preimageSizeFZF(int K) {
        return (int) (right_bound(K)-left_bound(K)+1);
    }
    public long left_bound(int target){
        long start=0;
        long end=Long.MAX_VALUE;
        while (start<=end){
            long mid=(start+end)/2;
            long k=trailingZeroes(mid);
            if(k<target){
                start=mid+1;
            }else if(k>target){
                end=mid-1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }
    public long right_bound(int target){
        long start=0;
        long end=Long.MAX_VALUE;
        while (start<=end){
            long mid=(start+end)/2;
            long k=trailingZeroes(mid);
            if(k<target){
                start=mid+1;
            }else if(k>target){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return end;
    }
    public long trailingZeroes(long n) {
        if(n<5){
            return 0;
        }
        long res=0;
        for (long i = 5; i <= n; i=i*5) {
            res=res+n/i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.preimageSizeFZF(0));
    }
}
