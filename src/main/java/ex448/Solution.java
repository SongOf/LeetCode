package ex448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        int length=nums.length;
        int[] count=new int[length+1];
        for (int i = 0; i < length; i++) {
            count[nums[i]]++;
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if(count[i]==0){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> res=solution.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}