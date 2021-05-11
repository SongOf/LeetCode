package ex32;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/7 22:43
 * @Version 1.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int length = chs.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(-1);
        int res = 0;
        for (int i = 0; i < length; i++) {
            if(chs[i] == '(')
                queue.push(i);
            else {
                queue.pop();
                if(queue.isEmpty())
                    queue.push(i);
                else
                    res = Math.max(res, i - queue.peek());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
}
