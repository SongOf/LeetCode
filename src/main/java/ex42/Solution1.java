package ex42;
//基于备忘录
public class Solution1 {
    public int trap(int[] height) {
        if(height==null){
            return -1;
        }else if(height.length<=2){
            return 0;
        }
        int res=0;
        int len=height.length;
        int[] l_max=new int[len];
        int[] r_max=new int[len];
        l_max[0]=height[0];
        r_max[len-1]=height[len-1];
        for(int i=1;i<len;i++){
            l_max[i]=Math.max(l_max[i-1],height[i]);
        }
        for(int i=len-2;i>=0;i--){
            r_max[i]=Math.max(r_max[i+1],height[i]);
        }
        for(int i=1;i<len-1;i++){
            res+=Math.min(l_max[i],r_max[i])-height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution1.trap(height));
    }
}
