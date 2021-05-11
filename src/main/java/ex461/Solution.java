package ex461;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/8 11:45
 * @Version 1.0
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if(z % 2 == 1) count ++;
            z = z / 2;
        }
        return count;
    }
}
