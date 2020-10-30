package ex1593;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private int max=Integer.MIN_VALUE;
    public int maxUniqueSplit(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Set<String> subStrSet=new HashSet();
        maxUniqueSplitCore(s,0,s.length(),subStrSet);
        return max;
    }
    public int maxUniqueSplitCore(String s,int start,int end,Set<String> subStrSet){
        int len=subStrSet.size();
        if(end-start+len<=max){
            return 0;
        }
        if(start==end){
            max=Math.max(max,len);
            return 0;
        }
        for(int i=start+1;i<=end;i++){
            if(!subStrSet.contains(s.substring(start,i))){
                subStrSet.add(s.substring(start,i));
                maxUniqueSplitCore(s,i,end,subStrSet);
                subStrSet.remove(s.substring(start,i));
            }
        }
        return 0;
    }
    public static void main(String[] args){
        String s="wwwzfvedwfvhsww";
        Solution solution = new Solution();
        System.out.println(solution.maxUniqueSplit(s));
    }
}
