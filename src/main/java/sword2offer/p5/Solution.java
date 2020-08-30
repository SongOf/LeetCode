package sword2offer.p5;
//关键在于要以追加的方式
public class Solution {
    public String replaceSpace(String s) {
        int sLen=s.length();
        StringBuffer res=new StringBuffer();
        for(int i=0;i<sLen;i++){
            if(s.charAt(i)==' ') {
                res.append("%20");
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String s="We are happy.";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(s));
    }
}
