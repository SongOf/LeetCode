package sword2offer.p57_2;

import java.util.LinkedList;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        if(target<3){
            return null;
        }
        int small=1;
        int big=2;
        LinkedList<int[]> res=new LinkedList<>();
        int curSum=small+big;
        int maxSmall=(target+1)/2;
        while (small<maxSmall){
            if(curSum==target){
                res.add(generateList(small,big));
                big++;
                curSum=curSum+big;
            }else if(curSum<target){
                big++;
                curSum=curSum+big;
            }else {
                curSum=curSum-small;
                small++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public int[] generateList(int start,int end){
        int[] res=new int[end-start+1];
        int pos=0;
        for(int i=start;i<=end;i++){
            res[pos]=i;
            pos++;
        }
        return res;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[][] res=solution.findContinuousSequence(15);
        for (int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
