class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int room = 0;
        int currIdx = 0;
        for(int i=0; i<intervals.length; i++) {
            
            //overlap
            if(start[i] < end[currIdx]) {
                room += 1;
            }
            else {
                currIdx ++;
            }
        }
        return room;
    }
}