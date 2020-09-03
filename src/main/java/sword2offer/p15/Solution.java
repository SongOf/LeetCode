package sword2offer.p15;
//n&(n-1)等于把n的最右边的1变成0
public class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(9));
    }
}
