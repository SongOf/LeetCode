package ex301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/22 11:47
 * @Version 1.0
 */
public class Solution {
    private Set<String> result = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemoves = 0;
        int rightRemoves = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] == '(') {
                leftRemoves++;
            }
            else if(chs[i] == ')' && leftRemoves <= 0) {
                rightRemoves++;
            }
            else if(chs[i] == ')' && leftRemoves > 0){
                leftRemoves--;
            }
        }
        System.out.println(leftRemoves);
        System.out.println(rightRemoves);
        StringBuffer sb = new StringBuffer();
        dfs(chs, 0, 0, 0, leftRemoves, rightRemoves, sb);
        return new ArrayList<>(result);
    }
    public void dfs(char[] chs, int index, int countLefts, int countRights, int leftRemoves, int rightRemoves, StringBuffer sb) {
        if(index == chs.length) {
            if(leftRemoves == 0 && rightRemoves == 0) result.add(new String(sb));
            return;
        }
        if(chs[index] == '(' && leftRemoves > 0) {
            dfs(chs, index + 1, countLefts, countRights, leftRemoves - 1, rightRemoves, sb);
        }
        else if(chs[index] == ')' && rightRemoves > 0) {
            dfs(chs, index + 1, countLefts, countRights, leftRemoves, rightRemoves - 1, sb);
        }
        sb.append(chs[index]);
        if(chs[index] != '(' && chs[index] != ')') {
            dfs(chs, index + 1, countLefts, countRights, leftRemoves, rightRemoves, sb);
        }
        else if(chs[index] == '(') {
            dfs(chs, index + 1, countLefts + 1, countRights, leftRemoves, rightRemoves, sb);
        }
        else if(countLefts > countRights) {
            dfs(chs, index + 1, countLefts, countRights + 1, leftRemoves, rightRemoves, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(a)())()";
        System.out.println(solution.removeInvalidParentheses(s));
    }
}
