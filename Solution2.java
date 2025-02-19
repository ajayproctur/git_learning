public class Solution2 {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        Solution2 s=new Solution2();
        System.out.println(s.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!isValidPosition(board, i, j)) return false;
            }
        }
        
        return true;
    }


    public boolean isValidPosition(char[][] board,int row,int col){
        char character=board[row][col];
        board[row][col]='.';
        //check in the row
        for(int i=0;i<9;i++){
            if(board[row][i]==character){
                return false;
            }
        }
        //check in the column
        for(int i=0;i<9;i++){
            if(board[i][col]==character){
                return false;
            }
        }

        //check in the 3X3 box
        int startRow=(row/3)*3;
        int startColumn=(col/3)*3;
        int endRow=startRow+3;
        int endColumn=startColumn+3;

        for(int i=startRow;i<endRow;i++){
            for(int j=startColumn;j<endColumn;j++){
                if(board[i][j]==character){
                    return false;
                }
            }
        }

        board[row][col]=character;

        return true;
    }
}
