package sword2offer.p33;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null){
            return false;
        }
        int len=postorder.length;
        if(len==1||len==0){
            return true;
        }
        return verifyPostorderCore(postorder,0,len-1);
    }
    public boolean verifyPostorderCore(int[] postorder,int left,int right){
        if(left==right){
            return true;
        }
        int start=0;
        int rootValue=postorder[right];
        for(start=left;start<right&&postorder[start]<rootValue;start++){

        }
        for(int i=start;i<right;i++){
            if(postorder[i]<rootValue){
                return false;
            }
        }
        if(start==left){
            return verifyPostorderCore(postorder,start,right-1);
        }
        if(start==right){
            return verifyPostorderCore(postorder,left,start-1);
        }
        return verifyPostorderCore(postorder,left,start-1)&&verifyPostorderCore(postorder,start,right-1);
    }
    public static void main(String[] args){
        int[] postorder={1,2,5,10,6,9,4,3};
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(postorder));
    }
}
