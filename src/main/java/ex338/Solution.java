package ex338;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/23 20:17
 * @Version 1.0
 */
public class Solution {
    public int[] countBits(int num) {
        int[] bitsCount = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bitsCount[i] = countBit1(i);
        }
        return bitsCount;
    }
    public int countBit1(int x) {
        int bitsOf1 = 0;
        while (x > 0) {
            bitsOf1++;
            x = x & (x -1);
        }
        return bitsOf1;
    }
}
