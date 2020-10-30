package ex85;

import java.util.Arrays;
import java.util.LinkedList;
//单调栈解决
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int[] heights=new int[matrix[0].length];
        Arrays.fill(heights,0);
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heights[j]=matrix[i][j]=='1'?heights[j]+1:0;
            }
            max=Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }
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
        Solution solution=new Solution();
        char[][] ma={{'0','1'},{'1','0'}};
//                {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle(ma));
    }
}
