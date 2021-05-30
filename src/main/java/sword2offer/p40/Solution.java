package sword2offer.p40;

public class Solution {
    public void quickSort(int[] arr) {
        if(arr == null || arr.length == 0) return;
        quickSortCore(arr, 0, arr.length - 1);
    }

    public void quickSortCore(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSortCore(arr, start, p - 1);
            quickSortCore(arr, p + 1, end);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) return new int[0];
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int p = partition(arr, start, end);
            if(p > k - 1) end = p - 1;
            else if(p < k - 1) start = p + 1;
            else break;
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public int partition(int[] arr, int start, int end) {
        int p = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= p) end --;
            arr[start] = arr[end];
            while (start < end && arr[start] <= p) start ++;
            arr[end] = arr[start];
        }
        arr[start] = p;
        return start;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr={3,2,1,523,9,23};
//        int[] res=solution.getLeastNumbers(arr,2);
        solution.quickSort(arr);
        int[] res= arr;
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
