package ex15;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsList= new ArrayList<>();

    }
    public static void main(String[] args){
        int[] nums ={-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> list=solution.threeSum(nums);
        for (int i=0;i<list.size();i++){
            System.out.println("["+list.get(i).get(0)+list.get(i).get(1)+list.get(i).get(2)+"]");
        }
    }
}
