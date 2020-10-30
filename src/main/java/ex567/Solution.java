package ex567;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null||s1.length()==0||s2==null||s2.length()==0||s2.length()<s1.length()){
            return false;
        }
        int[] need=new int[26];
        int[] window=new int[26];
        int s1Len=s1.length();
        int s2Len=s2.length();
        for(int i=0;i<26;i++){
            need[i]=0;
            window[i]=0;
        }
        int chIndex;
        int needSize=0;
        for(int i=0;i<s1Len;i++){
            chIndex=s1.charAt(i)-'a';
            if(need[chIndex]==0){
                needSize++;
            }
            need[chIndex]++;
        }
        int left=0,right=0;
        int valid=0;
        while (right<s2Len){
            chIndex=s2.charAt(right)-'a';
            right++;
            if(need[chIndex]>0){
                window[chIndex]++;
                if(need[chIndex]==window[chIndex]){
                    valid++;
                }
            }
            while (right-left>=s1Len){
                if(valid==needSize){
                    return true;
                }
                chIndex=s2.charAt(left)-'a';
                left++;
                if(need[chIndex]>0){
                    if (need[chIndex]==window[chIndex]){
                        valid--;
                    }
                    window[chIndex]--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        String s1="ab";
        String s2="eidboaoo";
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion(s1,s2));
    }
}
