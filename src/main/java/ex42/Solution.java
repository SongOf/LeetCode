package ex42;
//暴力解法
//关于单调栈应用 84-85 还有其他变形https://blog.csdn.net/qq_19446965/article/details/82048028
public class Solution {
    public int trap(int[] height) {
        if(height==null){
            return -1;
        }else if(height.length<=2){
            return 0;
        }
        int res=0;
        for(int loc=1;loc<height.length-1;loc++){
            int l_max=height[loc];
            int r_max=height[loc];
            int pos=loc-1;
            while (pos>=0){
                l_max=Math.max(l_max,height[pos]);
                pos--;
            }
            pos=loc+1;
            while (pos<height.length){
                r_max=Math.max(r_max,height[pos]);
                pos++;
            }
            res+=(Math.min(l_max,r_max)-height[loc]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }
}
