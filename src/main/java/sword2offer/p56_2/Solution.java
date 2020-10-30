package sword2offer.p56_2;

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int length=nums.length;
        int[] bitSum=new int[Integer.SIZE];
        int bitMask=1;
        int bit;
        for(int i=0;i<length;i++){
            bitMask=1;
            for(int j=Integer.SIZE-1;j>=0;j--){
                bit=nums[i]&bitMask;
                if(bit!=0){
                    bitSum[j]+=1;
                }
                bitMask=bitMask<<1;
            }
        }
        int res=0;
        for(int i=0;i<Integer.SIZE;i++){
            res=res<<1;
            res=res+bitSum[i]%3;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={3,4,3,3};
        Solution solution=new Solution();
        int res=solution.singleNumber(nums);
        System.out.println(res);
    }
}
