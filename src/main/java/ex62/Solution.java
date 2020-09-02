package ex62;

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        return dfs(m,n,0,0);
    }
    public int dfs(int m,int n,int i,int j){
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        int res=dfs(m,n,i+1,j)+dfs(m,n,i,j+1);
        return res;
    }
    public static void main(String[] args){
        int m=7,n=3;
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(m,n));
    }
}
