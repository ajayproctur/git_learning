
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
      return nqueen(board,0,0);
       
    }

    private int nqueen(char[][] board,int row,int pos){
        //base case
            if(row==board.length){
                return pos+1;
        }


        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='Q';
                nqueen(board,row+1,pos);
                board[row][i]='.';
            }
        }
                return pos;
    }

    private boolean isSafe(char[][] board,int i,int j){
        //north west
        int row=i,col=j;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        row=i;
        col=j;
        //north east
        while(row>=0 && col<board.length){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col++;
        }

        row=i;
        col=j;

        //south west

        while(row<board.length && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }

        row=i;
        col=j;
        //south east
            while(row<board.length && col<board.length){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col++;
        }
        row=i;
        col=j;
        //row
        for(int p=0;p<board.length;p++){
            if(board[row][p]=='Q'){
                return false;
            }
        }
        //col
        for(int p=0;p<board.length;p++){
            if(board[p][col]=='Q'){
                return false;
            }
        }

return true;
    }
}