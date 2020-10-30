package ex34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        if (nums==null||nums.length==0) {
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        res[0]=binarySearchLeft(nums,target);
        res[1]=binarySearchRight(nums,target);
        return res;
    }
    public int binarySearchLeft(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                right=mid-1;
            }
        }
        if(left>=nums.length||nums[left]!=target){
            return -1;
        }
        return left;
    }
    public int binarySearchRight(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                left=mid+1;
            }
        }
        if(right<0||nums[right]!=target){
            return -1;
        }
        return right;
    }
}
