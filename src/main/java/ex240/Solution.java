package ex240;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/22 0:49
 * @Version 1.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(target < matrix[i][0]) return false;
            int index = binarySearch(matrix[i], 0, matrix[i].length - 1, target);
            if(index >= 0) {
                return true;
            }
        }
        return false;
    }
    public int binarySearch(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if(target == a[mid]) return mid;
            else if(target > a[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(solution.searchMatrix(matrix, 5));
    }
}
