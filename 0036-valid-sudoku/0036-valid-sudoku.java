class Solution {
    public boolean isValidSudoku(char[][] board) {
        //create list for rol, col and box
        //the element in the list is hashset, no dulplicate allow in the set
        List<Set<Character>> rowCnt = new ArrayList();
        List<Set<Character>> colCnt = new ArrayList();
        List<Set<Character>> boxCnt = new ArrayList();
        for(int i=0; i<9; i++) {
            rowCnt.add(new HashSet());
            colCnt.add(new HashSet());
            boxCnt.add(new HashSet());
        }
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if(board[r][c] == '.') continue;
                if(!rowCnt.get(r).add(board[r][c])) return false;
                if(!colCnt.get(c).add(board[r][c])) return false;
                if(!boxCnt.get(r/3*3+c/3).add(board[r][c])) return false;
            }
        }
        return true;
    }
}