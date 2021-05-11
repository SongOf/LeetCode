package sword2offer.p4;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        for(int i = 0; i < m && matrix[i][0] <= target; i++) {
            if(binarySearch(matrix[i], target) != -1) return true;
        }
        return false;
    }
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
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
