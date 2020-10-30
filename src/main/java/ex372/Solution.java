package ex372;

public class Solution {
    private int mod=1337;
    public int superPow(int a, int[] b) {
        if(a<=0){
            return -1;
        }
        if(b==null||b.length==0){
            return 1;
        }
        return superPowCore(a,b,0,b.length-1);
    }
    public int superPowCore(int a, int[] b, int left, int right){
        if(left==right){
            return powMod(a,b[right]);
        }
        return powMod(a,b[right])*powMod(superPowCore(a,b,left,right-1),10)%mod;
    }
    public int powMod(int a,int p){
        if(p==0){
            return 1;
        }
        a=a%mod;
        if(p%2==1){
            return a*powMod(a,p-1)%mod;
        }else {
            int subPow=powMod(a,p/2);
            return subPow*subPow%mod;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int a=2;
        int[] b={1,0};
        System.out.println(solution.superPow(a,b));
    }
}
