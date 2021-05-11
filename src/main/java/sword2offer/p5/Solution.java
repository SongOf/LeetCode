package sword2offer.p5;
//关键在于要以追加的方式
public class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == ' ') sb.append("%20");
            else sb.append(chs[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s="We are happy.";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(s));
    }
}
