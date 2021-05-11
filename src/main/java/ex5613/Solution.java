package ex5613;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 10:35
 * @Version 1.0
 */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts==null||accounts.length==0) return 0;
        int max=0;
        for (int i = 0; i < accounts.length; i++) {
            int curAccount=0;
            for (int j = 0; j < accounts[i].length; j++) {
                curAccount+=accounts[i][j];
            }
            max=Math.max(max,curAccount);
        }
        return max;
    }
}
