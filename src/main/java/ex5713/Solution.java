package ex5713;

import java.util.HashSet;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/28 14:56
 * @Version 1.0
 */
public class Solution {
    public int numDifferentIntegers(String word) {
        char[] chs = word.toCharArray();
        HashSet<Integer> res = new HashSet<>();
        int start = 0;
        while (start < chs.length) {
            if(chs[start] >= '0' && chs[start] <= '9') {
                int num = 0;
                while (start < chs.length && chs[start] >= '0' && chs[start] <= '9') {
                    num = num * 10 + chs[start] - '0';
                    start++;
                }
                res.add(num);
            }
            else {
                start++;
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDifferentIntegers("a1b01c001"));
    }
}
