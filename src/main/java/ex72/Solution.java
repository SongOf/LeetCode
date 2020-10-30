package ex72;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String,Integer> remember=new HashMap<>();
    public int minDistance(String word1, String word2) {
        return minDistanceCore(word1,word1.length()-1,word2,word2.length()-1);
    }
    public int minDistanceCore(String word1,int pos1,String word2,int pos2) {
        if(remember.containsKey(""+pos1+pos2)){
            return remember.get(""+pos1+pos2);
        }
        if(pos1==-1) return pos2+1;
        if(pos2==-1) return pos1+1;
        int min=0;
        if(word1.charAt(pos1)==word2.charAt(pos2)){
            remember.put(""+pos1+pos2,minDistanceCore(word1,pos1-1,word2,pos2-1));
        }else {
            int add=minDistanceCore(word1,pos1,word2,pos2-1)+1;
            int del=minDistanceCore(word1,pos1-1,word2,pos2)+1;
            int place=minDistanceCore(word1,pos1-1,word2,pos2-1)+1;
            min=minOfThreeNum(place,add,del);
            remember.put(""+pos1+pos2,min);
        }
        return remember.get(""+pos1+pos2);
    }
    public int minOfThreeNum(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minDistance("intention","execution"));
    }
}
