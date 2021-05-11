package ex5614;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/11/29 10:38
 * @Version 1.0
 */
public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res=new int[k];
        int pos=0;
        int last=k-1;
        int start=0;
        int end=nums.length-1;
        for (int i = 0; i < k; i++) {
            int c=pick(nums,start,end,pos+k-last);
            if(c==end){
                res[last--]=nums[c];
                end=c-1;
            }else {
                res[pos++]=nums[c];
                start=c+1;
            }
        }
        return res;
    }
    public int pick(int[] nums,int start,int end,int len){
        int minNum=nums[end];
        int loc=end;
        for (int i = start; i <=end-len; i++) {
            if(minNum>nums[i]){
                minNum=nums[i];
                loc=i;
            }
        }
        return loc;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71};
        int k=24;
        nums=solution.mostCompetitive(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
