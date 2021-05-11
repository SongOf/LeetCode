package ex5618;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/12/6 10:52
 * @Version 1.0
 */
public class Solution {
    public int maxOperations(int[] nums, int k) {
        int length=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int count=0;
        for (int i = 0; i < length; i++){
            int tar=k-nums[i];
            if(map.containsKey(tar)&&map.get(tar)>0){
                count++;
                map.put(tar,map.get(tar)-1);
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={3,1,3,4,3};
        int k=6;
        System.out.println(solution.maxOperations(nums,k));
    }
}
