package sword2offer.p21;

public class Solution {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int temp;
        while (left<right){
            while(left<right&&nums[left]%2==1){
                left++;
            }
            while (left<right&&nums[right]%2==0){
                right--;
            }
            if(left<right){
                temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums={1,3,5};
        Solution solution = new Solution();
        int[] res=solution.exchange(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
}
