class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rLen = grid.length;
        int cLen = grid[0].length;
        int numIsland = 0;
        for(int r = 0; r<rLen; r++) {
            for(int c=0; c<cLen; c++) {
                if(grid[r][c] == '1') {
                    numIsland ++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIsland;
    }
    
    public void dfs(char[][] grid, int r, int c) {
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