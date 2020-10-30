package sword2offer.p47;

public class Solution1 {
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int[] dp=new int[col];
        int top;
        int left;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                top=0;
                left=0;
                if(i>0){
                    top=dp[j];
                }
                if(j>0){
                    left=dp[j-1];
                }
                dp[j]=Math.max(top,left)+grid[i][j];
            }
        }
        return dp[col-1];
    }
    public static void main(String[] args){
        int[][] grid={
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.maxValue(grid));
    }
}
