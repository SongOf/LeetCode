package sword2offer.p53_1;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        int tarIndex=binarySearch(nums,target);
        int count=0;
        for(int i=tarIndex;i<nums.length&&target==nums[i];i++){
            count++;
        }
        for(int i=tarIndex-1;i>=0&&target==nums[i];i--){
            count++;
        }
        return count;
    }
    public int binarySearch(int[] nums, int target){
        if(nums==null||nums.length<=0){
            return -1;
        }
        int high=nums.length-1;
        int low=0;
        int tar;
        while (low<high){
            tar=(low+high)/2;
            if(nums[tar]==target){
                return tar;
            }else if(nums[tar]<target){
                low=tar+1;
            }else {
                high=tar-1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        Solution solution=new Solution();
        System.out.println(solution.search(nums,target));
    }
}
