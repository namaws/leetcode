class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(board.length == 0 || word.length() == 0) return false;
        
        int row = board.length;
        int col = board[0].length;
        boolean result = false;
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(board[r][c] == word.charAt(0)) {
                    if(dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int r, int c, int idx) {
        int row = board.length;
        int col = board[0].length;
        
        if(r<0 || r>=row || c<0 || c>=col || board[r][c] != word.charAt(idx)) {
            return false;
        }
        
        // find the word
        if(board[r][c] == word.charAt(idx) && idx == word.length()-1) {
            return true;
        }
        
        board[r][c] = '0';
        boolean exist = dfs(board, word, r, c-1, idx+1) || dfs(board, word, r, c+1, idx+1) || dfs(board, word, r-1, c, idx+1) || dfs(board, word, r+1, c, idx+1);

        // restore board grid
        board[r][c] = word.charAt(idx);
        
        // as long as one found, then its true;
        return exist;
    }
}