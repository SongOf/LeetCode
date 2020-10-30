package sword2offer.p49;

public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0){
            return -1;
        }
        if(n==1){
            return 1;
        }
        int[] uglyNumber=new int[n];
        uglyNumber[0]=1;
        int pos_2=0;
        int pos_3=0;
        int pos_5=0;
        int next_2;
        int next_3;
        int next_5;
        for(int i=1;i<n;i++){
            while (uglyNumber[pos_2]*2<=uglyNumber[i-1]){
                pos_2++;
            }
            next_2=uglyNumber[pos_2]*2;
            while (uglyNumber[pos_3]*3<=uglyNumber[i-1]){
                pos_3++;
            }
            next_3=uglyNumber[pos_3]*3;
            while (uglyNumber[pos_5]*5<=uglyNumber[i-1]){
                pos_5++;
            }
            next_5=uglyNumber[pos_5]*5;
            uglyNumber[i]=Math.min(Math.min(next_2,next_3),next_5);
        }
        return uglyNumber[n-1];
    }
    public static void main(String[] args){
        int n=10;
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(n));
    }
}
