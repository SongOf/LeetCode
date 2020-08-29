package ex15;

import java.util.*;
//Set set = new HashSet(list);
//List list = new ArrayList(set);
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int numsLength=nums.length;
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list=null;
        Arrays.sort(nums);
        int i,j,k,sum;
        for(i=0;i<numsLength-2 && nums[i]<=0;i++){
            j=i+1;
            k=numsLength-1;
            while (k>j){
                sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                }
                else if(sum>0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args){
        int[] nums ={-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
        Solution solution = new Solution();
        List<List<Integer>> list=solution.threeSum(nums);
        for (int i=0;i<list.size();i++){
            System.out.println("["+list.get(i).get(0)+list.get(i).get(1)+list.get(i).get(2)+"]");
        }
    }
}
