package sword2offer.p53_2;
//存在缺失最后一位的情况
public class Solution {
    public int missingNumber(int[] nums) {
        return binarySearch(nums);
    }
    public int binarySearch(int[] nums){
        if(nums==null||nums.length==0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        int mid;
        while (low<=high){
            mid=(low+high)/2;
            if(mid==nums[mid]){
                low=mid+1;
            }else if(mid==0||nums[mid-1]==mid-1){
                return mid;
            }else {
                high=mid-1;
            }

        }
        //缺失最后一位 前面的元素和下标都相同
        if(low==nums.length){
            return low;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums={0,1,3};
        Solution solution=new Solution();
        System.out.println(solution.missingNumber(nums));
    }
}
