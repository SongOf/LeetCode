package sword2offer.p40;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||arr.length==0||k<=0){
            return new int[0];
        }
        int len=arr.length;
        int start=0;
        int end=len-1;
        int index=partition(arr,len,start,end);
        while (index!=k-1){
            if(index>k-1){
                end=index-1;
                index=partition(arr,len,start,end);
            }else {
                start=index+1;
                index=partition(arr,len,start,end);
            }
        }
        return Arrays.copyOfRange(arr,0,k);
    }
    public int partition(int[] arr,int length,int start,int end){
        if(arr==null||length<=0||start<0||end>=length){
            return -1;
        }
        int pivot=arr[start];
        while (start<end){
            while (start<end&&arr[end]>pivot){
                end--;
            }
            arr[start]=arr[end];
            while (start<end&&arr[start]<=pivot){
                start++;
            }
            arr[end]=arr[start];
        }
        arr[start]=pivot;
        return start;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr={3,2,1};
        int[] res=solution.getLeastNumbers(arr,2);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
