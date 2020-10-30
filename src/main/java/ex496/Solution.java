package ex496;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nums2Len=nums2.length;
        HashMap<Integer,Integer> nextGreaterMap=new HashMap<>();
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i = 0; i < nums2Len; i++) {
            while (!stack.isEmpty()&&stack.peek()<nums2[i]){
                nextGreaterMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            nextGreaterMap.put(stack.pop(),-1);
        }
        int nums1Len=nums1.length;
        int[] res=new int[nums1Len];
        for (int i = 0; i < nums1Len; i++) {
            res[i]=nextGreaterMap.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
        int[] res=solution.nextGreaterElement(nums1,nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
