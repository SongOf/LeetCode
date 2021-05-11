package ex240;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/22 1:26
 * @Version 1.0
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if(target < matrix[row][col]) row--;
            else if(target > matrix[row][col]) col++;
            else return true;
        }
        return false;
    }
}
