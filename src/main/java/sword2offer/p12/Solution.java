package sword2offer.p12;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        if(board==null || board[0]==null || word==null ||word.equals("")){
            return false;
        }
        boolean[][] mark=new boolean[row][col];
        char[] listWord=word.toCharArray();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==listWord[0]){
                    if(dfs(board,i,j,mark,listWord,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int i,int j,boolean[][] mark,char[] listWord,int pos){
        if(pos==listWord.length){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||mark[i][j]||board[i][j]!=listWord[pos]){
            return false;
        }
        mark[i][j]=true;
        boolean nextMatch=dfs(board,i+1,j,mark,listWord,pos+1)||dfs(board,i-1,j,mark,listWord,pos+1)||dfs(board,i,j+1,mark,listWord,pos+1)||dfs(board,i,j-1,mark,listWord,pos+1);
        mark[i][j]=false;
        return nextMatch;
    }
}
