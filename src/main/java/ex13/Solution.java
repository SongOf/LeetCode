package ex13;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/23 10:52
 * @Version 1.0
 */
public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                if(i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res = res + 4;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res = res + 9;
                    i++;
                }
                else {
                    res = res + 1;
                }
            }
            else if(s.charAt(i) == 'V') {
                res = res + 5;
            }
            else if(s.charAt(i) == 'X') {
                if(i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res = res + 40;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res = res + 90;
                    i++;
                }
                else {
                    res = res + 10;
                }
            }
            else if(s.charAt(i) == 'L') {
                res = res + 50;
            }
            else if(s.charAt(i) == 'C') {
                if(i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    res = res + 400;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    res = res + 900;
                    i++;
                }
                else {
                    res = res + 100;
                }
            }
            else if(s.charAt(i) == 'D') {
                res = res + 500;
            }
            else if(s.charAt(i) == 'M') {
                res = res + 1000;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
