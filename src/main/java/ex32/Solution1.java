package ex32;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/7 22:55
 * @Version 1.0
 */
public class Solution1 {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0,right = 0;
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] == '(') left++;
            else right++;
            if(left == right) res = Math.max(res, left*2);
            else if(right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            if(chs[i] == '(') left++;
            else right++;
            if(left == right) res = Math.max(res, left*2);
            else if(right < left) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
}
