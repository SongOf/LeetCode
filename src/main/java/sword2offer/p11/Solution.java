package sword2offer.p11;

public class Solution {
    public int minArray(int[] numbers) {
        int len=numbers.length;
        int index1=0;
        int index2=len-1;
        int tarIndex=index1;
        while (numbers[index1]>=numbers[index2]){
            if(index2-index1==1){
                tarIndex=index2;
                break;
            }
            tarIndex=(index1+index2)/2;
            if(numbers[index1]==numbers[index2] && numbers[index1]==numbers[tarIndex]){
                return traceAll(numbers);
            }
            if(numbers[index1]<=numbers[tarIndex]){
                index1=tarIndex;
            }else if(numbers[index2]>=numbers[tarIndex]){
                index2=tarIndex;
            }
        }
        return numbers[tarIndex];
    }
    public int traceAll(int[] numbers) {
        int len=numbers.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] numbers={2,2,2,0,1};
        Solution solution = new Solution();
        System.out.println(solution.minArray(numbers));
    }
}
