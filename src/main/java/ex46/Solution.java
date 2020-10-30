package ex46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        permuteCore(nums,0,nums.length-1,res);
        return res;
    }
    public void permuteCore(int[] nums,int start,int end,List<List<Integer>> res) {
        if(start==end){
            List<Integer> row=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                row.add(nums[i]);
            }
            res.add(row);
        }
        int temp;
        for(int i=start;i<=end;i++){
            if(i==start||nums[i]!=nums[start]){
                temp=nums[i];
                nums[i]=nums[start];
                nums[start]=temp;
                permuteCore(nums,start+1,end,res);
                temp=nums[i];
                nums[i]=nums[start];
                nums[start]=temp;
            }
        }
    }
    public static void main(String[] args){
        int[] nums ={1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums));
    }
}
