package sword2offer.p59_1;

import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||k<=0||k>nums.length){
            return new int[0];
        }
        int length=nums.length;
        int[] res=new int[length-k+1];
        int pos=0;
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<k;i++){
            while (!queue.isEmpty()&&nums[i]>=nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.add(i);
        }
        res[pos]=nums[queue.get(0)];
        pos++;
        for(int i=k;i<length;i++){
            while (!queue.isEmpty()&&i-k>=queue.get(0)){
                queue.removeFirst();
            }
            while (!queue.isEmpty()&&nums[i]>=nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.add(i);
            res[pos]=nums[queue.get(0)];
            pos++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,3,-1,-3,5,3,6,7};
        Solution solution=new Solution();
        int[] res=solution.maxSlidingWindow(nums,3);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}