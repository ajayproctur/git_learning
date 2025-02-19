
public class Solution1 {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 11, 16, 5, 20},
            {17, 4, 19, 10, 15},
            {12, 1, 8, 21, 6},
            {3, 18, 23, 14, 9},
            {24, 13, 2, 7, 22}
        };
    //     int[][] grid = {
    // {0, 3, 6},
    // {5, 8, 1},
    // {2, 7, 4}
// };
Solution1 s=new Solution1();
System.out.println(s.checkValidGrid(grid));        
} 

    public   boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        return helper(grid, 0, 0, 1);
    }

    public   boolean helper(int[][] grid, int row, int col, int pos) {
        int n = grid.length;
        if (pos == n * n) {
            return true;
        }

        return isSafe(grid, row, col, pos);
    }

    public   boolean isSafe(int[][] grid, int row, int col, int pos) {
        //up-left
        if (row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == pos) {
            return helper(grid, row - 2, col - 1, pos + 1);
        }
        //up-right
        if (row - 2 >= 0 && col + 1 < grid.length && grid[row - 2][col + 1] == pos) {
            return helper(grid, row - 2, col + 1, pos + 1);
        }
        //right-up
        if (row - 1 >= 0 && col + 2 < grid.length && grid[row - 1][col + 2] == pos) {
            return helper(grid, row - 1, col + 2, pos + 1);
        }
        //right-down
        if (row + 1 < grid.length && col + 2 < grid.length && grid[row + 1][col + 2] == pos) {
            return helper(grid, row + 1, col + 2, pos + 1);
        }
        //down-right
        if (row + 2 < grid.length && col + 1 < grid.length && grid[row + 2][col + 1] == pos) {
            return helper(grid, row + 2, col + 1, pos + 1);
        }
        //down-left
        if (row + 2 < grid.length && col - 1 >= 0 && grid[row + 2][col - 1] == pos) {
            return helper(grid, row + 2, col - 1, pos + 1);
        }
        //left-down
        if (row + 1 < grid.length && col - 2 >= 0 && grid[row + 1][col - 2] == pos) {
            return helper(grid, row + 1, col - 2, pos + 1);
        }
        //left-up
        if (row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == pos) {
            return helper(grid, row - 1, col - 2, pos + 1);
        }

        return false;
    }

}
