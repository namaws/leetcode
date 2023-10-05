class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> col = new ArrayList(); // count the virtical line
        List<Set<Character>> row = new ArrayList(); // count the horizontal line
        List<Set<Character>> box = new ArrayList();
        
        for(int i=0; i<board.length; i++) {
            col.add(new HashSet());
            row.add(new HashSet());
            box.add(new HashSet());
        }

        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                char ch = board[r][c];
                if(ch == '.')
                    continue;
                else if(!col.get(r).add(ch))
                    return false;
                else if(!row.get(c).add(ch))
                    return false;
                else if(!box.get(r/3*3+c/3).add(ch))
                    return false;
            }
        }
        return true;
    }
}