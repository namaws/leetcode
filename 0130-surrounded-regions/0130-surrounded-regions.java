class Solution {
    public void solve(char[][] board) {
        //unsurrounded region (flip the unsurrounded first)
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O' && 
                   (i == 0 || i == board.length-1 || 
                    j == 0 || j == board[0].length-1)) {
                    flip(board, i, j);
                }
            }
        }
        
        //flip surrounded region
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
        //flip T -> O
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
        return;
    }
    
    private void flip(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length
           || board[r][c] != 'O' )
            return;
        board[r][c] = 'T';
        flip(board, r, c-1);
        flip(board, r, c+1);
        flip(board, r-1, c);
        flip(board, r+1, c);
        return;
    }
}