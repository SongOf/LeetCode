package sword2offer.p53_1;

public class Solution1 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        int firstIndex=firstIndexOfTar(nums,target);
        int lastIndex=lastIndexOfTar(nums,target);
        if(firstIndex>-1&&lastIndex>-1){
            return lastIndex-firstIndex+1;
        }
        return 0;
    }
    public int firstIndexOfTar(int[] nums, int target){
        if(nums==null||nums.length<=0){
            return -1;
        }
        int high=nums.length-1;
        int low=0;
        int tar;
        while (low<=high){
            tar=(low+high)/2;
            if(nums[tar]==target){
                if(tar==0||(tar>0&&nums[tar-1]!=target)){
                    return tar;
                }else {
                    high=tar-1;
                }
            }else if(nums[tar]<target){
                low=tar+1;
            }else {
                high=tar-1;
            }
        }
        return -1;
    }
    public int lastIndexOfTar(int[] nums, int target){
        if(nums==null||nums.length<=0){
            return -1;
        }
        int length=nums.length-1;
        int high=length;
        int low=0;
        int tar;
        while (low<=high){
            tar=(low+high)/2;
            if(nums[tar]==target){
                if(tar==length||(tar<length&&nums[tar+1]!=target)){
                    return tar;
                }else {
                    low=tar+1;
                }
            }else if(nums[tar]<target){
                low=tar+1;
            }else {
                high=tar-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        Solution1 solution1=new Solution1();
        System.out.println(solution1.search(nums,target));
    }
}
