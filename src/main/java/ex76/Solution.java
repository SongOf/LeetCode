package ex76;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0||t==null||t.length()==0||s.length()<t.length()) {
            return "";
        }
        int slen=s.length();
        int tlen=t.length();
        int[] need=new int[64];
        int[] window=new int[64];
        for(int i=0;i<64;i++){
            need[i]=0;
            window[i]=0;
        }
        int needSize=0;
        int chIndex;
        for(int i=0;i<tlen;i++){
            chIndex=t.charAt(i)-'A';
            if(need[chIndex]==0){
                needSize++;
            }
            need[chIndex]++;
        }
        int left=0,right=0;
        int valid=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;
        while (right<slen){
            chIndex=s.charAt(right)-'A';
            right++;
            if(need[chIndex]>0){
                window[chIndex]++;
                if(need[chIndex]==window[chIndex]){
                    valid++;
                }
            }
            while (valid==needSize){
                if(right-left<minLen){
                    minStart=left;
                    minLen=right-left;
                }
                chIndex=s.charAt(left)-'A';
                left++;
                if(need[chIndex]>0){
                    if(need[chIndex]==window[chIndex]){
                        valid--;
                    }
                    window[chIndex]--;
                }
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
    public static void main(String[] args){
        String s="ADOBECODEBANC";
        String t="ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s,t));
    }
}