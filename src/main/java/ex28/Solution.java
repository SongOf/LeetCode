package ex28;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/2/27 12:09
 * @Version 1.0
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackChars.length; i++) {
            if(equals(haystackChars, i, needleChars))
                return i;
        }
        return -1;
    }
    public boolean equals(char[] haystackChars, int index, char[] needleChars) {
        int i = index, j = 0;
        while (i < haystackChars.length && j < needleChars.length) {
            if(haystackChars[i] != needleChars[j]) return false;
            i++;
            j++;
        }
        if(j == needleChars.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaaaa", "bba"));
        HashMap<String, Integer> hs = new HashMap<>();
        hs.put("1", 1);
        hs.put("2", 2);
//        Iterator<Map.Entry<String, Integer>> it = hs.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, Integer> item = it.next();
//            it.remove();
//        }
        for(Map.Entry<String, Integer> item : hs.entrySet()) {
            hs.remove(item.getKey());
        }
        for(Map.Entry<String, Integer> item : hs.entrySet()) {
            System.out.println(item.getValue());
        }
    }
}
