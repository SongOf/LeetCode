package sword2offer.p48;
//基于动态规划的
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int length=s.length();
        int[] position=new int[130];
        int[] dp=new int[length];
        for(int i=0;i<130;i++){
            position[i]=-1;
        }
        char[] str=s.toCharArray();
        position[str[0]]=0;
        dp[0]=1;
        int d=0;
        for(int i=1;i<length;i++){
            d=i-position[str[i]];
            if(position[str[i]]==-1||d>dp[i-1]){
                dp[i]=dp[i-1]+1;
            }else if(d<=dp[i-1]){
                dp[i]=d;
            }
            position[str[i]]=i;
        }
        int max=0;
        for(int i=0;i<length;i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        String str="abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
}
