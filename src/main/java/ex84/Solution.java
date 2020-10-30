package ex84;
//暴力解法
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int max=0;
        for (int i = 0; i < len; i++) {
            int left=i;
            while ((left-1)>=0&&heights[left-1]>=heights[i]){
                left--;
            }
            int right=i;
            while ((right+1)<len&&heights[right+1]>=heights[i]){
                right++;
            }
            int curS=heights[i]*(right-left+1);
            if(max<curS) max=curS;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] heights={2,4};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
