package ex5;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1||s.length()==0){
            return s;
        }
        int maxLength=0;
        String res="";
        int j=0;
        String reverseSubStr="";
        String subStr="";
        for(int i=0;i<s.length()-1;i++){
            reverseSubStr="";
            subStr="";
            subStr=subStr+s.charAt(i);
            reverseSubStr=reverseSubStr+s.charAt(i);
            for(j=i;j<s.length();){
                if(subStr.equals(reverseSubStr) && maxLength<(j-i+1)){
                    maxLength=j-i+1;
                    res=subStr;
                }
                j++;
                subStr=subStr+s.charAt(j);
                reverseSubStr=s.charAt(j)+reverseSubStr;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s="ac";
        Solution solution = new Solution();
        String res= solution.longestPalindrome(s);
        System.out.println(res);
    }
}
