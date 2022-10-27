class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int currMaxEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            //overlap
            if(start < currMaxEnd) {
                return false;
            }
            
            //renew currMaxEnd
            currMaxEnd = Math.max(currMaxEnd, end);
        }
        return true;
    }
}