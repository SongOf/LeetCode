package sword2offer.p50;

public class Solution {
    public char firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return ' ';
        }
        int[] chCounter=new int[26];
        int length=s.length();
        char[] str=s.toCharArray();
        for (int i=0;i<length;i++){
            chCounter[str[i]-'a']++;
        }
        for(int i=0;i<length;i++){
            if(chCounter[str[i]-'a']==1){
                return str[i];
            }
        }
        return ' ';
    }
    public static void main(String[] args){
        String s="abaccdeff";
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(s));
    }
}
