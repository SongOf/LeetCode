package sword2offer.p13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs(m,n,0,0,visited,k);
    }
    public int dfs(int m, int n, int i, int j, boolean[][] visited, int k){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || digitsSum(i)+digitsSum(j)>k){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(m,n,i-1,j,visited,k)+dfs(m,n,i+1,j,visited,k)+dfs(m,n,i,j-1,visited,k)+dfs(m,n,i,j+1,visited,k);
    }
    public int digitsSum(int n){
        int sum=0;
        while (n!=0){
            sum=sum+n%10;
            n=n/10;
        }
        return sum;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3,1,0));
    }
}
