package ex136;

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res=res^nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={2,2,1};
        System.out.println(solution.singleNumber(nums));
    }
}
