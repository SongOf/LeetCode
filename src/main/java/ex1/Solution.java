package ex1;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=j;
                    res[1]=i;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums ={2, 7, 11, 15};
        Solution solution = new Solution();
        int[] res=solution.twoSum(nums,9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
