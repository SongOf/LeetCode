package ex22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/2/22 22:41
 * @Version 1.0
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisCore(result, 0, 0, new StringBuilder(), n);
        return result;
    }
    public void generateParenthesisCore(List<String> result, int right, int left, StringBuilder item, int n) {
        if(item.length() == 2 * n) {
            result.add(item.toString());
            return;
        }
        if(right < n) {
            item.append('(');
            generateParenthesisCore(result, right + 1, left, item, n);
            item.deleteCharAt(item.length() - 1);
        }
        if(left < right) {
            item.append(')');
            generateParenthesisCore(result, right, left + 1, item, n);
            item.deleteCharAt(item.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        for(String s : res) {
            System.out.println(s);
        }
    }
}
