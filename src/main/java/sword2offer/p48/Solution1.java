package sword2offer.p48;
//基于滑动窗口的
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int sLen=s.length();
        int[] widow=new int[128];
        for(int i=0;i<128;i++){
            widow[i]=0;
        }
        int left=0,right=0;
        int chIndex;
        int maxLen=Integer.MIN_VALUE;
        while (right<sLen){
            chIndex=s.charAt(right);
            right++;
            widow[chIndex]++;
            while (widow[chIndex]>1){
                widow[s.charAt(left)]--;
                left++;
            }
            if(maxLen<right-left){
                maxLen=right-left;
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        String str="pwwkew";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring(str));
    }
}
