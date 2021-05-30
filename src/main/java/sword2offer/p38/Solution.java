package sword2offer.p38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    private Set<String> res = new HashSet<>();
    public String[] permutation(String s) {
        if(s != null && s.length() >= 1) {
            char[] chs = s.toCharArray();
            permutationCore(chs, 0, chs.length - 1);
        }
        return new ArrayList<>(res).toArray(new String[res.size()]);
    }
    public void permutationCore(char[] chs, int start, int end) {
        if(start == end) {
            res.add(new String(chs));
            return;
        }
        char ch;
        for(int i = start; i <= end; i ++) {
            if(i == start || chs[i] != chs[start]) {
                ch = chs[i];
                chs[i] = chs[start];
                chs[start] = ch;
                permutationCore(chs, start + 1, end);
                ch = chs[i];
                chs[i] = chs[start];
                chs[start] = ch;
            }
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.permutation(null));
        String[] res=solution.permutation(new String("abc"));
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
