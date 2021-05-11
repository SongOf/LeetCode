package ex39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/9 0:15
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        combinationSumCore(ans, combine, 0, candidates, target);
        return ans;
    }
    public void combinationSumCore(List<List<Integer>> ans, List<Integer> combine, int idx, int[] candidates, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if(idx >= candidates.length) return;
        combinationSumCore(ans, combine, idx + 1, candidates, target);
        if(target >= candidates[idx]) {
            combine.add(candidates[idx]);
            combinationSumCore(ans, combine, idx, candidates, target - candidates[idx]);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2,3,5};
        System.out.println(solution.combinationSum(candidates, 8));
    }
}
