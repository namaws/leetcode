class Solution {
    
    private int[][] directions = {
        {0,1}, {0,-1}, {1,0}, {-1,0},
    };
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] minObstacles = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }
        
        //start from top-left corners, accounting its obstacle value
        minObstacles[0][0] = grid[0][0];
        
        // a[0] < b[0]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        //starting cell of the pq, [obstacles value, row, col]
        pq.add(new int[] {minObstacles[0][0], 0, 0});
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int obstacles = current[0], row = current[1], col = current[2];
            
            //reach the bottom-right
            if(row == m-1 && col == n-1)
                return obstacles;
            
            for(int[] dir: directions) {
                int newRow = row+dir[0], newCol = col+dir[1];
                
                if(isValid(grid, newRow, newCol)) {
                    //if there's obstacle in curr pos, there is value 1 in grid
                    int newObstacles = obstacles + grid[newRow][newCol];
                    
                    if(newObstacles < minObstacles[newRow][newCol]) {
                        minObstacles[newRow][newCol] = newObstacles;
                        pq.add(new int[] {newObstacles, newRow, newCol});
                    }
                }
            }
        }
        return minObstacles[m-1][n-1];
    }
    
    
    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}