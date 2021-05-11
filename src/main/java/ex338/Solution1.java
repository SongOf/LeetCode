package ex338;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/23 20:22
 * @Version 1.0
 */
public class Solution1 {
    public int[] countBits(int num) {
        int[] bitsNum = new int[num + 1];
        int highbit = 0;
        for (int i = 1; i <= num; i++) {
            if((i & (i - 1)) == 0) {
                highbit = i;
            }
            bitsNum[i] = bitsNum[i - highbit] + 1;
        }
        return bitsNum;
    }
}
