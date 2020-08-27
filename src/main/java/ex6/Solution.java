package ex6;
//char 初始化值为'\u0000'
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char [][] charMatrix=new char[1000][1000];
        int row=0;
        int col=0;
        int pos=0;
        while (pos<s.length()){
            for(;row<numRows && pos<s.length();row++){
                charMatrix[row][col]=s.charAt(pos);
                pos++;
            }
            row=row-2;
            for(;row>=0 && pos<s.length();row--){
                col++;
                charMatrix[row][col]=s.charAt(pos);
                pos++;
            }
            row=row+2;;
        }
        String res="";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=col;j++){
                if(charMatrix[i][j]!='\u0000'){
                    res=res+charMatrix[i][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s="AB";
        int numRows = 1;
        Solution solution = new Solution();
        String res=solution.convert(s,numRows);
        System.out.println(res);
    }
}
