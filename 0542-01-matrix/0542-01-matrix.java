class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int INF = row+col;
        //first examine top and left of each cell
        // -> don't need to examine when row/col = 0
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(mat[r][c] == 0) continue;
                int left = INF, top = INF;
                if(r-1 >= 0) top = mat[r-1][c];
                if(c-1 >= 0) left = mat[r][c-1];
                mat[r][c] = Math.min(left, top)+1;
            }
        }
        
        for(int r=row-1; r>=0; r--) {
            for(int c=col-1; c>=0; c--) {
                if(mat[r][c] == 0) continue;
                int right = INF, down = INF;
                if(r+1 < row) down = mat[r+1][c];
                if(c+1 < col) right = mat[r][c+1];
                //need to double check mat itself, due to if the cell is the right down corner
                //it would not go to the above if statement, the right and down would stay INF
                mat[r][c] = Math.min(mat[r][c],Math.min(right, down)+1);
            }
        }
        return mat;
    }
}