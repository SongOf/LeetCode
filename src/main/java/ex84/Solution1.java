package ex84;

import java.util.LinkedList;
//利用单调栈
public class Solution1 {
    public int largestRectangleArea(int[] heights){
        int length=heights.length;
        LinkedList<Integer> stack=new LinkedList<>();
        int[] left=new int[length];
        int[] right=new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = length-1; i >=0; i--) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?length:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int max=0;
        for (int i = 0; i < length; i++) {
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        int[] heights={2,1,5,6,2,3};
        System.out.println(solution1.largestRectangleArea(heights));
    }
}
