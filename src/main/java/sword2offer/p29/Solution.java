package sword2offer.p29;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int rows=matrix.length;
        if(matrix==null||rows==0){
            return new int[0];
        }
        int cols=matrix[0].length;
        int start=0;
        int[] res=new int[rows*cols];
        int pos=0;
        int endX=0;
        int endY=0;
        while (start*2<rows&&start*2<cols){
            endX=rows-1-start;
            endY=cols-1-start;
            for(int i=start;i<=endY;i++){
                res[pos]=matrix[start][i];
                pos++;
            }
            if(start<endX){
                for(int i=start+1;i<=endX;i++){
                    res[pos]=matrix[i][endY];
                    pos++;
                }
            }
            if(start<endX&&start<endY){
                for(int i=endY-1;i>=start;i--){
                    res[pos]=matrix[endX][i];
                    pos++;
                }
            }
            if(start<endX-1&&start<endY){
                for(int i=endX-1;i>start;i--){
                    res[pos]=matrix[i][start];
                    pos++;
                }
            }
            start++;
        }
        return res;
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution solution = new Solution();
        int[] res=solution.spiralOrder(matrix);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
}
