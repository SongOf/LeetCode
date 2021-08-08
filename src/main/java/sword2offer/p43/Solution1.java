package sword2offer.p43;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/6/15 23:19
 * @Version 1.0
 */
public class Solution1 {
    public int countDigitOne(int n) {
        int high = n;
        int low = 0;
        int cur = 0;
        int res = 0;
        int exp = 1;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high = high / 10;
            if(cur == 0) res += high * exp;
            else if(cur == 1) res += high * exp + low + 1;
            else res += high * exp + exp;
            low = exp * cur + low;
            exp = exp * 10;
        }
        return res;
    }
}
