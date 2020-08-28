package ex11;

public class Solution {
    public int maxArea(int[] height) {
        int len=height.length;
        int maxValue=0;
        int tempValue=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                tempValue=(j-i)*Math.min(height[i],height[j]);
                if(maxValue<tempValue){
                    maxValue=tempValue;
                }
            }
        }
        return maxValue;
    }
    public static void main(String[] args){
        int[] height ={1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}
