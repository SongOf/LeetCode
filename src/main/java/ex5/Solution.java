package ex5;
//中心扩展法
public class Solution {
    public String longestPalindrome(String s) {
        int sLength=s.length();
        if(sLength<2){
            return s;
        }

        int maxLength=0;
        int[] resLoc=null;
        int[] resLocTemp=null;

        int len=0;
        for(int i=0;i<sLength;i++){
            resLocTemp=this.centerExpand(s,i,i);
            len=resLocTemp[1]-resLocTemp[0]+1;
            if(maxLength<len){
                maxLength=len;
                resLoc=resLocTemp;
            }
            resLocTemp=this.centerExpand(s,i,i+1);
            len=resLocTemp[1]-resLocTemp[0]+1;
            if(maxLength<len){
                maxLength=len;
                resLoc=resLocTemp;
            }
        }
        return s.substring(resLoc[0],resLoc[1]+1);
    }
    public int[] centerExpand(String s,int left,int right){
        int[] resLoc=new int[2];
        int sLength=s.length();
        while(left>=0 && right<sLength && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        resLoc[0]=left;
        resLoc[1]=right;
        return resLoc;
    }
    public static void main(String[] args){
        String s="babad";
        Solution solution = new Solution();
        String res= solution.longestPalindrome(s);
        System.out.println(res);
    }
}
