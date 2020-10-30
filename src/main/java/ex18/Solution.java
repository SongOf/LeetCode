package ex18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new ArrayList();
        }
        Arrays.sort(nums);
        return nSumTarget(nums,4,0,target);
    }
    public List<List<Integer>> nSumTarget(int[] nums,int n,int start, int target){
        List<List<Integer>> res=new ArrayList<>();
        int numsLength=nums.length;
        if(n<2||n>numsLength){
            return res;
        }
        if(n==2){
            int low=start;
            int high=nums.length-1;
            int left,right,sum;
            List<Integer> tuple;
            while (low<high){
                left=nums[low];
                right=nums[high];
                sum=nums[low]+nums[high];
                if(sum<target){
                    while (low<high&&nums[low]==left){
                        low++;
                    }
                }else if(sum>target){
                    while (low<high&&nums[high]==right){
                        high--;
                    }
                }else {
                    tuple=new ArrayList<>();
                    tuple.add(nums[low]);
                    tuple.add(nums[high]);
                    res.add(tuple);
                    while (low<high&&nums[low]==left){
                        low++;
                    }
                    while (low<high&&nums[high]==right){
                        high--;
                    }
                }
            }
        }else {
            List<List<Integer>> temp;
            for(int i=start;i<numsLength;i++){
                temp=nSumTarget(nums,n-1,i+1,target-nums[i]);
                for(int j=0;j<temp.size();j++){
                    temp.get(j).add(nums[i]);
                }
                res.addAll(temp);
                while (i<numsLength-1&&nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums,int start, int target){
        List<List<Integer>> res=new ArrayList<>();
        List<List<Integer>> temp;
        int numsLen=nums.length;
        for(int i=start;i<numsLen;i++){
            temp=threeSum(nums,i+1,target-nums[i]);
            for(int j=0;j<temp.size();j++){
                temp.get(j).add(nums[i]);
            }
            res.addAll(temp);
            while (i<numsLen-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums,int start, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<List<Integer>> temp;
        int numsLen=nums.length;
        for(int i=start;i<numsLen;i++){
            temp=twoSum(nums,i+1,target-nums[i]);
            for(int j=0;j<temp.size();j++){
                temp.get(j).add(nums[i]);
            }
            res.addAll(temp);
            while (i<numsLen-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums,int start,int target){
        int low=start;
        int high=nums.length-1;
        int left,right,sum;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tuple;
        while (low<high){
            left=nums[low];
            right=nums[high];
            sum=nums[low]+nums[high];
            if(sum<target){
                while (low<high&&nums[low]==left){
                    low++;
                }
            }else if(sum>target){
                while (low<high&&nums[high]==right){
                    high--;
                }
            }else {
                tuple=new ArrayList<>();
                tuple.add(nums[low]);
                tuple.add(nums[high]);
                res.add(tuple);
                while (low<high&&nums[low]==left){
                    low++;
                }
                while (low<high&&nums[high]==right){
                    high--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums ={1, 0, -1, 0, -2, 2};
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums,0));
    }
}
