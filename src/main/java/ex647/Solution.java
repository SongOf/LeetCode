package ex647;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/10 13:24
 * @Version 1.0
 */
public class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < 2 * chs.length - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < chs.length && chs[left] == chs[right]) {
                ans ++;
                left --;
                right ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
    }
}
