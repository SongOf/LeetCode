package sword2offer.p17;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private char[] num;
    private List<Integer> ans;

    public int[] printNumbers(int n) {
        num = new char[n];
        ans = new ArrayList<>();
        dfs(0, n);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void dfs(int index, int n) {
        if(index == n) {
            String numStr = String.valueOf(num);
            int tmp = Integer.parseInt(numStr);
            if(tmp != 0) ans.add(tmp);
            return;
        }
        for(int i = '0'; i <= '9'; i++) {
            num[index] = (char) i;
            dfs(index + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.printNumbers(10));
    }
}
