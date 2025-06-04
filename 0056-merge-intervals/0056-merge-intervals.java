class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList();
        int currStart = intervals[0][0], currEnd = intervals[0][1];
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] <= currEnd) {
                currEnd = Math.max(currEnd, intervals[i][1]);
            }
            else {
                list.add(new int[]{currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }

            if(i == intervals.length-1) {
                list.add(new int[]{currStart, currEnd});
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}