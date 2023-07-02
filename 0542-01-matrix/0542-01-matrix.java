class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int len = mat.length + mat[0].length;
        int row = mat.length;
        int col = mat[0].length;
        //top, left
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                int left = len, top = len;
                if(mat[r][c] == 0) continue;
                if(r-1 >= 0) top = mat[r-1][c];
                if(c-1 >= 0) left = mat[r][c-1];
                mat[r][c] = Math.min(top,left)+1;
            }
        }
        //down, right
        for(int r=row-1; r>=0; r--) {
            for(int c=col-1; c>=0; c--) {
                int right = len, down = len;
                if(mat[r][c] == 0) continue;
                if(r+1 < row) down = mat[r+1][c];
                if(c+1 < col) right = mat[r][c+1];
                mat[r][c] = Math.min(mat[r][c], Math.min(down, right)+1);
            }
        }
        return mat;
    }
}