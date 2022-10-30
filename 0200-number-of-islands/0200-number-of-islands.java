class Solution {
    public int numIslands(char[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == '1') {
                    num++;
                    grid[r][c] = '0';
                    queue.add(r*col + c);
                    while(!queue.isEmpty()) {
                        int curr = queue.remove();
                        int currR = curr/col;
                        int currC = curr%col;
                        //down
                        if(currR-1 >=0 && grid[currR-1][currC] == '1') {
                            queue.add((currR-1)*col + currC);
                            grid[currR-1][currC] = '0';
                        }
                        
                        if(currR+1 < row && grid[currR+1][currC] == '1') {
                            queue.add((currR+1)*col + currC);
                            grid[currR+1][currC] = '0';
                        }
                        
                        if(currC-1 >= 0 && grid[currR][currC-1] == '1') {
                            queue.add(currR*col + currC-1);
                            grid[currR][currC-1] = '0';
                        }
                        
                        if(currC+1 < col && grid[currR][currC+1] == '1') {
                            queue.add(currR*col + currC+1);
                            grid[currR][currC+1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }
}