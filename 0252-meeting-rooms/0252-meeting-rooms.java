class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int currMaxEnd = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start < currMaxEnd)
                return false;
            else {
                currMaxEnd = Math.max(currMaxEnd, end);
            }
        }
        return true;
    }
}