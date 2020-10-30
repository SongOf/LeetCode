package ex448;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        int length=nums.length;
        int index;
        for (int i = 0; i < length; i++) {
            index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=nums[index]*-1;
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if(nums[i-1]>0){
                res.add(i);
            }
        }
        return res;
    }
}
