package ex438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null||s.length()==0||p==null||p.length()==0||s.length()<p.length()){
            return new ArrayList<>();
        }
        List<Integer> res=new ArrayList<>();
        int sLen=s.length();
        int pLen=p.length();
        int[] need=new int[26];
        int needSize=0;
        int[] window=new int[26];
//        for(int i=0;i<26;i++){
//            need[i]=0;
//            window[i]=0;
//        }
        int chIndex;
        for(int i=0;i<pLen;i++){
            chIndex=p.charAt(i)-'a';
            if(need[chIndex]==0){
                needSize++;
            }
            need[chIndex]++;
        }
        int left=0;
        int right=0;
        int valid=0;
        while (right<sLen){
            chIndex=s.charAt(right)-'a';
            right++;
            if(need[chIndex]>0){
                window[chIndex]++;
                if(need[chIndex]==window[chIndex]){
                    valid++;
                }
            }
            while (right-left>=pLen){
                if(valid==needSize){
                    res.add(left);
                }
                chIndex=s.charAt(left)-'a';
                left++;
                if(need[chIndex]>0){
                    if(need[chIndex]==window[chIndex]){
                        valid--;
                    }
                    window[chIndex]--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s="baa";
        String p="aa";
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s,p));
    }
}
