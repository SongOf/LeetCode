package sword2offer.p56_1;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        int length=nums.length;
        int sumExclusiveOR=0;
        for(int i=0;i<length;i++){
            sumExclusiveOR ^=nums[i];
        }
        int indexOfFirst1=findIndexOfFirst1(sumExclusiveOR);
        sumExclusiveOR=0;
        int sumExclusiveOR_=0;
        for(int i=0;i<length;i++){
            if(is1IndexOf(nums[i],indexOfFirst1)){
                sumExclusiveOR ^=nums[i];
            }else {
                sumExclusiveOR_ ^=nums[i];
            }
        }
        int[] res={sumExclusiveOR,sumExclusiveOR_};
        return res;
    }
    public int findIndexOfFirst1(int num){
        int index=0;
        while ((num&1)==0 && index<Integer.SIZE){
            num=num>>1;
            index++;
        }
        return index;
    }
    public boolean is1IndexOf(int num,int index){
        num=num>>index;
        return (num&1)==1;
    }
    public static void main(String[] args){
        int[] nums={4,1,4,6};
        Solution solution=new Solution();
        int[] res=solution.singleNumbers(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
