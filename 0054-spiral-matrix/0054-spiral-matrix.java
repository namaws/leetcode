class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int startR = 0, startC = 0;
        int endR = matrix.length-1, endC = matrix[0].length-1;

        while(startR <= endR && startC <= endC) {
            for(int c=startC; c<=endC; c++) 
                list.add(matrix[startR][c]);
            startR++;

            for(int r=startR; r<=endR; r++)
                list.add(matrix[r][endC]);
            endC--;

            if(startR <= endR) {
            for(int c=endC; c>=startC; c--) 
                list.add(matrix[endR][c]);}
            endR--;
            if(startC <= endC) {
            for(int r=endR; r>=startR; r--)
                list.add(matrix[r][startC]);}
            startC++;
        }
        return list;

    }
}