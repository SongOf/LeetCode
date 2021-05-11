package ex5712;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/20 23:06
 * @Version 1.0
 */
public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        HashSet<Long> res = new HashSet<>();
        getMaximumConsecutiveCore(coins, 0, 0, res);
        List<Long> nums = new ArrayList<>(res);
        Collections.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.size(); i++) {
            if(count == nums.get(i)) count++;
            else break;
        }
        return count;
    }
    public void getMaximumConsecutiveCore(int[] coins, int index, long count, Set<Long> nums) {
        if(index >= coins.length) return;
        count += coins[index];
        nums.add(count);
        getMaximumConsecutiveCore(coins, index + 1, count, nums);
        count -= coins[index];
        getMaximumConsecutiveCore(coins, index + 1, count, nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1,4,10,3,1};
        System.out.println(solution.getMaximumConsecutive(coins));
    }
}
