package sword2offer.p39;

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int length=nums.length;
        int tar=nums[0];
        int tarFre=1;

        for(int i=1;i<length;i++){
            if(tar==nums[i]){
                tarFre++;
            }else {
                tarFre--;
                if(tarFre==0){
                    i++;
                    tar=nums[i];
                    tarFre=1;
                }
            }
        }
        if(tarFre>=1){
            return tar;
        }else {
            return -1;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.majorityElement(nums));
    }
}
