package ex394;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/25 10:17
 * @Version 1.0
 */
public class Solution {
    private int pos;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] chs = s.toCharArray();
        pos = 0;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        while (pos < chs.length) {
            if(Character.isDigit(chs[pos])) {
                Integer num = getInteger(chs);
                if(num != 0) numStack.push(num);
            }
            else if(Character.isLetter(chs[pos]) || chs[pos] == '[') {
                strStack.push("" + chs[pos++]);
            }
            else {
                String str = getString(strStack);
                strStack.pop();
                Integer c = numStack.pop();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < c; i++) {
                    sb.append(str);
                }
                strStack.push(sb.toString());
                pos++;
            }
        }
        StringBuffer res = new StringBuffer();
        while (!strStack.isEmpty()) {
            res.append(strStack.pollLast());
        }
        return res.toString();
    }
    public Integer getInteger(char[] chs) {
        StringBuffer sb = new StringBuffer();
        while (pos < chs.length && chs[pos] >= '0' && chs[pos] <= '9') {
            sb.append(chs[pos++]);
        }
        return sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;
    }
    public String getString(LinkedList<String> strStack) {
        List<String> list = new ArrayList<>();
        while (!"[".equals(strStack.peek())) {
            list.add(strStack.pop());
        }
        Collections.reverse(list);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
