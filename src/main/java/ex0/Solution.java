package ex0;
//快速排序、合并排序、堆排序
public class Solution {
    public void quickSort(int[] nums){
        if(nums == null){
            return;
        }
        quickSortCore(nums,0,nums.length-1);
    }
    public void quickSortCore(int[] nums,int low,int high){
        if(low<high){
            int p=partition(nums,low,high);
            quickSortCore(nums,low,p-1);
            quickSortCore(nums,p+1,high);
        }
    }
    public int partition(int[] nums,int low,int high){
        int pivot=nums[low];
        while (low<high){
            while (low<high&&nums[high]>=pivot){ //必须有个带等号
                high--;
            }
            nums[low]=nums[high];
            while (low<high&&nums[low]<=pivot){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }

    public void mergeSort(int[] nums){
        if(nums == null){
            return;
        }
        mergeSortCore(nums,0,nums.length-1);
    }
    public void mergeSortCore(int[] nums,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSortCore(nums,low,mid);
            mergeSortCore(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }
    public void merge(int[] nums,int low,int mid,int high){
        int[] tmp=new int[high-low+1];
        int cur=0;
        int lowPos=low;
        int highPos=mid+1;
        while (lowPos<=mid&&highPos<=high){
            if(nums[lowPos]<nums[highPos]){
                tmp[cur++]=nums[lowPos++];
            }else {
                tmp[cur++]=nums[highPos++];
            }
        }
        while (lowPos<=mid){
            tmp[cur++]=nums[lowPos++];
        }
        while (highPos<=high){
            tmp[cur++]=nums[highPos++];
        }
        cur=0;
        for (int i = low; i <= high; i++,cur++) {
            nums[i]=tmp[cur];
        }
    }

    public void heapSort(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }
    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }
    public void maxHeapify(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large=i;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={2,6,2,8,3,5};
//        solution.quickSort(nums);
//        solution.mergeSort(nums);
        solution.heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
