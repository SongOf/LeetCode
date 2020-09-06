package sword2offer.p19;

public class Solution1 {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        if(p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
        }else{
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && (isMatch(s.substring(1), p.substring(1)));
        }
    }
    public static void main(String[] args){
        String s="aa";
        String p="a*";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s,p));
    }
}
