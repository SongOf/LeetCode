package ex1011;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights==null||weights.length<=0){
            return -1;
        }
        int left=findMax(weights),right=sum(weights);
        while (left<=right){
            int mid=(left+right)/2;
            int days=daysForPack(weights,mid,D);
            if(days>D){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
    public int daysForPack(int[] weights,int K,int D){
        int days=0;
        int length=weights.length;
        int canPack=K;
        for(int i=0;i<length;i++){
            if(K<weights[i]){
                return D+1;
            }
            if(canPack>=weights[i]){
                canPack-=weights[i];
            }else {
                days++;
                canPack=K;
                canPack-=weights[i];
            }
        }
        return days+1;
    }
    public int sum(int[] weights){
        if(weights==null||weights.length<=0){
            return 0;
        }
        int s=0;
        for (int i=0;i<weights.length;i++){
            s+=weights[i];
        }
        return s;
    }
    public int findMax(int[] weights){
        if(weights==null||weights.length<=0){
            return -1;
        }
        int max=weights[0];
        for (int i=1;i<weights.length;i++){
            if(max<weights[i]){
                max=weights[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] weights={1,2,3,1,1};
        System.out.println(solution.shipWithinDays(weights,4));
    }
}
