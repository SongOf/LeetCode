package sword2offer.p20;

public class Solution {
    public boolean isNumber(String s) {
        int slen = s.length();
        int start = 0;
        int loc=0;
        for(int i=0;i<slen;i++){
            if(s.charAt(i)=='.'||s.charAt(i)=='e'||s.charAt(i)=='E'){
                loc=i;
                break;
            }
        }
        if(loc==0){
            while (start < slen) {
                if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                    start++;
                }
                if(s.charAt(start) < '0'||s.charAt(start) > '9'){
                    return false;
                }
                start++;
            }
            return true;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            start = 1;
        }
        while (start < loc &&s.charAt(start) >= '0'&&s.charAt(start) <= '9') {
            start++;
        }
        if (start == loc && s.charAt(start) == '.') {
            start++;
            while (start < slen && s.charAt(start) >= '0'&&s.charAt(start) <= '9') {
                start++;
            }
        }
        if (start < slen && (s.charAt(start) == 'e' || s.charAt(start) == 'E')) {
            start++;
            if(start>=slen){
                return false;
            }
            if (s.charAt(start) == '-' || s.charAt(start) == '+') {
                start++;
            }
            while (start < slen && s.charAt(start) >= '0'&&s.charAt(start) <= '9') {
                start++;
            }
        }
        return start==slen;

    }
    public static void main(String[] args){
        String s="1234";
        Solution solution = new Solution();
        System.out.println(solution.isNumber(s));
    }
}
