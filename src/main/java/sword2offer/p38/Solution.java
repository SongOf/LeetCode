package sword2offer.p38;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    private Set<String> res=new HashSet<String>();
    public String[] permutation(String s) {
        if(s==null||s.length()==0){
            return new String[0];
        }
        StringBuilder tarString=new StringBuilder(s);
        permutationCore(tarString,0,tarString.length()-1);
        String[] permutationList=new String[res.size()];
        int pos=0;
        Iterator iterator=res.iterator();
        while (iterator.hasNext()){
            permutationList[pos]=(String)iterator.next();
            pos++;
        }
        return permutationList;
    }
    public void permutationCore(StringBuilder s,int start,int end){
        if(start==end){
            res.add(new String(s));
            return;
        }
        char ch;
        for(int i=start;i<=end;i++){
            if(i==start||s.charAt(start)!=s.charAt(i)){
                ch=s.charAt(start);
                s.setCharAt(start,s.charAt(i));
                s.setCharAt(i,ch);
                permutationCore(s,start+1,end);
                ch=s.charAt(start);
                s.setCharAt(start,s.charAt(i));
                s.setCharAt(i,ch);
            }
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String[] res=solution.permutation(new String("abc"));
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
