class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        int row = grid.length; 
        int col = grid[0].length;
        for(int r = 0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == '1') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        }
        return num;
    }
    
    public void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
    }
}