package ex503;

import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int numsLen=nums.length;
        int[] res=new int[numsLen];
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i = numsLen*2-1; i >= 0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums[i%numsLen]){
                stack.pop();
            }
            res[i%numsLen]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%numsLen]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,2,1};
        int[] res=solution.nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
