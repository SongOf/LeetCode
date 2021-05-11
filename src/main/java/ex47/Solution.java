package ex47;

import java.util.*;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description 交换+HashMap剔除重复 （也可以使用set对结果去重）
 * @Date 2020/12/6 12:11
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        permuteUniqueCore(nums,0,nums.length-1,res);
        return res;
    }
    public void permuteUniqueCore(int[] nums,int start,int end,List<List<Integer>> res) {
        if(start==end){
            List<Integer> row=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                row.add(nums[i]);
            }
            res.add(row);
        }
        int temp;
        HashMap<Integer,Integer> mark=new HashMap<>();
        for(int i=start;i<=end;i++){
            if(!mark.containsKey(nums[i])){
                mark.put(nums[i],0);
                temp=nums[i];
                nums[i]=nums[start];
                nums[start]=temp;
                permuteUniqueCore(nums,start+1,end,res);
                temp=nums[i];
                nums[i]=nums[start];
                nums[start]=temp;
            }
        }
    }
    public static void main(String[] args){
        int[] nums ={2,2,1,1};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(nums));
    }
}
