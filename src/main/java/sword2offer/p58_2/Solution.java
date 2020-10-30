package sword2offer.p58_2;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        if(s==null||s.length()==0||n<0){
            return "";
        }
        if(n==0||n==s.length()){
            return s;
        }
        if(n>s.length()){
            n=n%s.length();
        }
        int sLength=s.length();
        char[] str=s.toCharArray();
        reverse(str,0,n-1);
        reverse(str,n,sLength-1);
        reverse(str,0,sLength-1);
        return new String(str);
    }
    public void reverse(char[] s,int start,int end){
        if(start<0||end<0){
            return;
        }
        char ch;
        while (start<end){
            ch=s[start];
            s[start]=s[end];
            s[end]=ch;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        String s="";
        Solution solution=new Solution();
        System.out.println(solution.reverseLeftWords(s,s.length()+1));
    }
}
