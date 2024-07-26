class Solution{
int rows , cols, totalIsland = 0;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if(rows == 0 || grid == null) return 0;
        
        for(int row = 0; row < rows ; row++) {
            check(grid, row);
        }
        return totalIsland;
    }

    private void check(char[][] grid, int row) {
        char[] currRow = grid[row];
        for(int col = 0 ; col < cols; col++) {
            if(currRow[col] == '1') {
                totalIsland++;
                bfs(grid, row, col);
            }
        }
    }


    private void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '0'; //visited
        if(row > 0 && grid[row - 1][col] == '1') bfs(grid, row - 1, col);
        if(row + 1 < rows && grid[row + 1][col] == '1') bfs(grid, row + 1, col);
        if(col > 0 && grid[row][col - 1] == '1') bfs(grid, row, col - 1);
        if(col + 1 < cols && grid[row][col + 1] == '1') bfs(grid, row, col + 1);
    }
}