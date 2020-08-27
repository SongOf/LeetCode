package ex4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length=nums1.length;
        int nums2Length=nums2.length;
        if(nums1Length==0){
            if(nums2Length%2==0){
                return (double)(nums2[nums2Length/2]+nums2[nums2Length/2-1])/2;
            }else{
                return (double)nums2[nums2Length/2];
            }
        }
        if(nums2Length==0){
            if(nums1Length%2==0){
                return (double)(nums1[nums1Length/2]+nums1[nums1Length/2-1])/2;
            }
            else {
                return (double)nums1[nums1Length/2];
            }
        }
        int[] mergenums= new int[nums1Length+nums2Length];
        int iLen=0;
        int jLen=0;
        int pos=0;

        while (iLen<nums1Length && jLen<nums2Length){
            if(nums1[iLen]<nums2[jLen]){
                mergenums[pos]=nums1[iLen];
                iLen++;
            }else {
                mergenums[pos]=nums2[jLen];
                jLen++;
            }
            pos++;
        }
        while (iLen<nums1Length){
            mergenums[pos]=nums1[iLen];
            iLen++;
            pos++;
        }
        while (jLen<nums2Length){
            mergenums[pos]=nums2[jLen];
            jLen++;
            pos++;
        }
        if(pos%2==0){
            return (double) (mergenums[pos/2]+mergenums[pos/2-1])/2;
        }else {
            return (double) mergenums[pos/2];
        }
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println("----------------------------");
        double res=solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }
}
