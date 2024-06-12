class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length-1, colEnd = matrix[0].length-1;
        
        
        while(colStart <= colEnd && rowStart <= rowEnd) {
            
            for(int c=colStart; c<=colEnd; c++) {
                list.add(matrix[rowStart][c]);
            }
            rowStart++;
            
            for(int r=rowStart; r<=rowEnd; r++) {
                list.add(matrix[r][colEnd]);
            }
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int c=colEnd; c>=colStart; c--) {
                list.add(matrix[rowEnd][c]);
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int r=rowEnd; r>=rowStart; r--) {
                list.add(matrix[r][colStart]);
                }
            }
            colStart++;
        }
        return list;
    }
}