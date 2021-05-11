package ex5701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/14 10:30
 * @Version 1.0
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < chs1.length; i++) {
            if(chs1[i] != chs2[i]) {
                count++;
                if(count == 1) {
                    index1 = i;
                }
                else if(count == 2) {
                    index2 = i;
                    char tmp = chs1[index1];
                    chs1[index1] = chs1[index2];
                    chs1[index2] = tmp;
                    for (int j = 0; j < chs1.length; j++) {
                        if(chs1[j] != chs2[j]) return false;
                    }
                    return true;
                }
            }
        }
        if(count == 0) return true;
        return false;
    }
}
