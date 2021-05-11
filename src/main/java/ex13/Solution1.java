package ex13;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/2/19 9:39
 * @Version 1.0
 */
public class Solution1 {
    public int romanToInt(String s) {
        int result = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curNum = getValue(s.charAt(i));
            if(preNum < curNum) {
                result -= preNum;
            }
            else {
                result += preNum;
            }
            preNum = curNum;
        }
        result += preNum;
        return result;
    }
    public int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.romanToInt("MCMXCIV"));
    }
}
