package ex42;

public class Solution2 {
    public int trap(int[] height){
        if(height==null){
            return -1;
        }else if(height.length<=2){
            return 0;
        }
        int res=0;
        int left=0;
        int right=height.length-1;
        int l_max=height[left];
        int r_max=height[right];
        while (left<right){
            l_max=Math.max(l_max,height[left]);
            r_max=Math.max(r_max,height[right]);
            if(l_max<r_max){
                res+=l_max-height[left];
                left++;
            }else {
                res+=r_max-height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution1.trap(height));
    }
}
