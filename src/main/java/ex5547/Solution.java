package ex5547;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len=l.length;
        List<Boolean> res=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(isArithmeticSubarrays(nums,l[i],r[i]));
        }
        return res;
    }
    public boolean isArithmeticSubarrays(int[] nums,int l,int r){
        if(r-l<1) return false;
        int[] temp=Arrays.copyOfRange(nums,l,r+1);
        Arrays.sort(temp);
        int d=temp[1]-temp[0];
        for (int i = 2; i <=r-l; i++) {
            if(d!=(temp[i]-temp[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l={0,1,6,4,8,7};
        int[] r={4,4,9,7,9,10};
        List<Boolean> res=solution.checkArithmeticSubarrays(nums,l,r);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
