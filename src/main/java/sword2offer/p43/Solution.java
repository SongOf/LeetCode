package sword2offer.p43;

public class Solution {
    public int countDigitOne(int n) {
        int count=0;
        int temp=0;
        for(int i=1;i<=n;i++){
            temp=i;
            while (temp!=0){
                if(temp%10==1){
                    count++;
                }
                temp=temp/10;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n =824883294;
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(n));
    }
}
