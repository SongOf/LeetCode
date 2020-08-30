package sword2offer.p3;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int numsLength=nums.length;
        if(numsLength==1){
            return -1;
        }
        int[] repeatMark=new int[numsLength];
        for(int i=0;i<numsLength;i++){
            repeatMark[nums[i]]++;
        }
        for(int j=0;j<numsLength;j++){
            if(repeatMark[j]>1 ){
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(nums));
    }
}
