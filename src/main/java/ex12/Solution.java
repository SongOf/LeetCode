package ex12;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/2/19 14:19
 * @Version 1.0
 */
public class Solution {
    public static final String[] romanKeys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] valuesOfRoman = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < valuesOfRoman.length && num > 0; i++) {
            while (num >= valuesOfRoman[i]) {
                sbuf.append(romanKeys[i]);
                num -= valuesOfRoman[i];
            }
        }
        return sbuf.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }
}
