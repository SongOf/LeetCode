package ex15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=null;
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        int i,j,k;
        for(i=1;i<nums.length-1;i++){
            for (j=0;j<i;j++){
                for(k=i+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        list=new ArrayList<>();
                        list.add(nums[j]);
                        list.add(nums[i]);
                        list.add(nums[k]);
                        res.add(list);
                        if(nums[i]==0){
                            while (nums[i]==0 && i<nums.length-1){
                                i++;
                            }
                            i--;
                        }
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums ={3,0,-2,-1,1,2};
        Solution solution = new Solution();
        List<List<Integer>> list=solution.threeSum(nums);
        for (int i=0;i<list.size();i++){
            System.out.println("["+list.get(i).get(0)+list.get(i).get(1)+list.get(i).get(2)+"]");
        }
    }
}
