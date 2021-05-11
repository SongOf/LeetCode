package ex47;

import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description dfs回溯+hashmap去重
 * @Date 2020/12/6 15:02
 * @Version 1.0
 */
public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Deque<Integer> path=new ArrayDeque<>();
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        dfs(nums,nums.length,0,path,used,res);
        return res;
    }
    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(len==depth){
            res.add(new ArrayList<>(path));
            return;
        }
        HashMap<Integer,Integer> mark=new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(used[i]||mark.containsKey(nums[i])) continue;
            mark.put(nums[i],0);
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        int[] nums={2,2,1,1};
        System.out.println(solution1.permuteUnique(nums));
    }
}
