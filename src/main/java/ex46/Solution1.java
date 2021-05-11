package ex46;

import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description dfs-回溯
 * @Date 2020/12/6 14:19
 * @Version 1.0
 */
public class Solution1 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Deque<Integer> path=new ArrayDeque<>();
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        dfs(nums,nums.length,0,path,used,res);
        return res;
    }
    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(len==depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,len,depth+1,path,used,res);
                path.removeLast();
                used[i]=false;
            }
        }
    }
}
