package ex78;

import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/11 0:43
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetsCore(nums, 0, res, subSet);
        return new ArrayList<>(res);
    }
    public void subsetsCore(int[] nums, int pos, List<List<Integer>> res, List<Integer> subSet) {
        if(pos == nums.length) {
            res.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(nums[pos]);
        subsetsCore(nums, pos + 1, res, subSet);
        subSet.remove(subSet.size() - 1);
        subsetsCore(nums, pos + 1, res, subSet);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(nums);
        for (List<Integer> sub : res) {
            for(Integer item : sub) {
                System.out.print(item);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
