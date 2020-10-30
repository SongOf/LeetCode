package ex16;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int numsLength=nums.length;
        Arrays.sort(nums);
        int i,j,k,sum=nums[0]+nums[1]+nums[2];
        int sumTemp;
        for(i=0;i<numsLength-2;i++){
            j=i+1;
            k=numsLength-1;
            while (j<k){
                sumTemp=nums[i]+nums[j]+nums[k];
                if(Math.abs(sumTemp-target)<Math.abs(sum-target)){
                    sum=sumTemp;
                }
                if(target<sumTemp){
                    k--;
                }else if(target>sumTemp){
                    j++;
                }else {
                    return sum;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] nums ={-1,2,1,-4};
        int target = 1;
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums,target));
    }
}
