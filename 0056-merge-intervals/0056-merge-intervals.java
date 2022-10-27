class Solution {
    public int[][] merge(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<int[]> list = new ArrayList<>();
        
        // i start idx
        // j end idx
        for(int i=0, j=0; j<intervals.length; j++) {
            //last intervals or a new interval started
            if( j == intervals.length-1 || start[j+1] > end[j] ) {
                list.add(new int[] {start[i], end[j]});
                i = j+1;
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}