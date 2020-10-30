package ex875;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles==null||piles.length<=0||H<piles.length){
            return -1;
        }
        int left=1,right=findMax(piles);
        while (left<=right){
            int mid=(left+right)/2;
            int eatTimes=eating(piles,mid);
            if(eatTimes>H){
                left=mid+1;
            }else if(eatTimes<H){
                right=mid-1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
    public int eating(int[] piles,int K){
        int times=0;
        int length=piles.length;
        for(int i=0;i<length;i++){
            times=times+piles[i]/K+(piles[i]%K>0?1:0);
        }
        return times;
    }
    public int findMax(int[] piles){
        if(piles==null||piles.length<=0){
            return -1;
        }
        int max=piles[0];
        for (int i=1;i<piles.length;i++){
            if(max<piles[i]){
                max=piles[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] piles={30,11,23,4,20};
        System.out.println(solution.minEatingSpeed(piles,5));
    }
}
