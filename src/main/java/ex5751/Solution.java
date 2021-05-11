package ex5751;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/5/9 10:56
 * @Version 1.0
 */
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;

        int max = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            while (index1 < nums1.length && nums1[index1] > nums2[index2]) index1 ++;
            if(index1 > index2) index2 = index1;
            while (index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]) index2 ++;
            max = Math.max(max, index2 - index1 - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};
        System.out.println(solution.maxDistance(nums1, nums2));
    }
}
