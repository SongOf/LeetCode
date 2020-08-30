package sword2offer.p4;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i=0;matrix.length>0 && i<matrix.length;i++){
            for(int j=0;matrix[i].length>0 && j<matrix[i].length && matrix[i][j]<=target;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix= {
                {1, 4, 7, 11, 15},
                {},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target=20;
        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(matrix,target));
    }
}
