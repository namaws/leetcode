class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> subBox = new ArrayList();
        List<Set<Character>> row = new ArrayList();
        List<Set<Character>> col = new ArrayList();
        for(int i=0; i<9; i++) {
            subBox.add(new HashSet());
            row.add(new HashSet());
            col.add(new HashSet());
        }
        
        /**
        subBox
        0, 1, 2
        3, 4, 5
        6, 7, 8
        */
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                char ch = board[r][c];
                if(ch == '.') continue;
                else if(row.get(r).contains(ch) || col.get(c).contains(ch) || subBox.get(r/3*3+c/3).contains(ch)) {
                    return false;
                }
                row.get(r).add(ch);
                col.get(c).add(ch);
                subBox.get(r/3*3+c/3).add(ch);
            }
        }
        return true;
    }
}