
public class SudokuSolver {
    
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public void solve(char[][] board, int row, int col) {
        if (row == 9) {
            return;
        } else if (board[row][col] != '.') {
            if (col < 8) {
                solve(board, row, col + 1); 
            }else {
                solve(board, row + 1, 0);
            }
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValidPosition(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col < 8) {
                        solve(board, row, col + 1); 
                    }else {
                        solve(board, row + 1, 0);
                    }
                    board[row][col] = '.';
                }
            }
        }

    }

    public boolean isValidPosition(char[][] board, int row, int col, char character) {
        // char character=board[row][col];
        // board[row][col]='.';
        //check in the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == character) {
                return false;
            }
        }
        //check in the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == character) {
                return false;
            }
        }

        //check in the 3X3 box
        int startRow = (row / 3) * 3;
        int startColumn = (col / 3) * 3;
        int endRow = startRow + 3;
        int endColumn = startColumn + 3;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startColumn; j < endColumn; j++) {
                if (board[i][j] == character) {
                    return false;
                }
            }
        }

        // board[row][col]=character;
        return true;
    }

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
        // char[][] board = {
        //     {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        //     {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        //     {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
        // };

        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(board);

    }

}
