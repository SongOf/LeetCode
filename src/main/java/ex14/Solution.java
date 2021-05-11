package ex14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for (int i = 1; i <strs.length; i++) {
            prefix=longestCommonPrefixCore(prefix,strs[i]);
            if(prefix.length()==0){
                return "";
            }
        }
        return prefix;
    }
    public String longestCommonPrefixCore(String prefix,String str){
        int length=Math.min(prefix.length(),str.length());
        int i=0;
        while (i <length&&prefix.charAt(i)==str.charAt(i)){
            i++;
        }
        return prefix.substring(0,i);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] strs={"ab","a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}