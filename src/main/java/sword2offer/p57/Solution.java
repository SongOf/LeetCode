package sword2offer.p57;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0||target<2){
            return null;
        }
        int high=nums.length-1;
        int low=0;
        int curSum;
        while (low<high){
            curSum=nums[low]+nums[high];
            if(curSum==target){
                return new int[]{nums[high],nums[low]};
            }else if(curSum>target){
                high--;
            }else{
                low++;
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums={2,7,11,15};
        Solution solution=new Solution();
        int[] res=solution.twoSum(nums,9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
