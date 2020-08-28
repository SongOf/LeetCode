package ex10;

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLength=s.length();
        int pLength=p.length();
        int locs=0;
        int locp=0;
        char matchChar='#';
        for(locp=0;locp<pLength;locp++){
            if(s.charAt(locs)==p.charAt(locp) || p.charAt(locp)=='.'){
                locs++;
                locp++;
            }
            if(p.charAt(locp)=='*'){
                matchChar=s.charAt(locs);
                while (locs<sLength && matchChar == s.charAt(locs)){
                    locs++;
                }
            }
            if(s.charAt(locs)!=p.charAt(locp)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s="aa";
        String p="a";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s,p));
    }
}
