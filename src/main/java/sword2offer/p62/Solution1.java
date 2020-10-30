package sword2offer.p62;

public class Solution1 {
    public int lastRemaining(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        int ans=0;
        for(int i=2;i<n;i++){
            ans=(ans+m)%i;
        }
        return ans;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.lastRemaining(10,17));
    }
}
